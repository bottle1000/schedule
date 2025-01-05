package pbc.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pbc.schedule.exception.NotFoundAuthorException;
import pbc.schedule.utils.JwtUtil;

import java.io.IOException;

@Slf4j(topic = "JwtFilter")
@RequiredArgsConstructor
public class JwtFilter implements Filter {

    private final JwtUtil jwtUtil;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String requestURI = httpRequest.getRequestURI();
        String username = null;
        String jwt = null;

        String authorizationHeader = httpRequest.getHeader("Authorization");

        if (requestURI.equals("/user/login")) {
            filterChain.doFilter(httpRequest, httpResponse);
            return;
        }

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotFoundAuthorException("JWT 토큰이 필요합니다.");
        }

        jwt = authorizationHeader.substring(7);

        if (!jwtUtil.validateToken(jwt)) {
            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
            httpResponse.getWriter().write("{\"error\": \"Unauthorized\"}");
        }

        username = jwtUtil.extractUsername(jwt);

        if (requestURI.startsWith("/admin")) {

            if (jwtUtil.hasRole(jwt, "ADMIN")) {
                filterChain.doFilter(httpRequest, httpResponse);
            } else {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 권한이 없습니다.");
            }
            return;
        }

        if (requestURI.startsWith("/user")) {

            if (jwtUtil.hasRole(jwt, "USER") || jwtUtil.hasRole(jwt, "ADMIN")) {
                filterChain.doFilter(httpRequest, httpResponse);
            } else {
                httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "접근 권한이 없습니다.");
            }
            return;
        }

        // 비회원 유저 API
        filterChain.doFilter(httpRequest, httpResponse);
    }
}
