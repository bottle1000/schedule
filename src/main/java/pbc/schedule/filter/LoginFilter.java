package pbc.schedule.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;
import pbc.schedule.SessionConst;

import java.io.IOException;

@Slf4j
public class LoginFilter implements Filter {

    //이 경로들은 filter 를 거치지 않음.
    private static final String[] WHITE_LIST = {"/user/signup", "/user/login", "/user"};

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURI = httpRequest.getRequestURI();

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        log.info("로그인 필터 로직 실행");

        // 화이트 리스트에 포함되지 않은 URI의 경우 로직을 거침
        if (!isWhiteList(requestURI)) {
            HttpSession session = httpRequest.getSession(false);

            if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
                throw new RuntimeException("로그인 해주세요.");
            }

        }

        //1번 경우 : WHITE_LIST에 등록된 URL 요청이라면 chain.doFilter() 호출
        //2번 경우 : WHITE_LIST가 아닌 경우 위 필터 로직을 통과 후에 chain.doFilter() 다음 필터나 Servlet을 호출

        //다음 필터가 없으면 Servlet -> Controller, 다음 필터가 있으면 다음 필터 호출한다.
        filterChain.doFilter(request, response);

    }

    /**
     * 현재 들어온 URI 와 화이트 리스트 URI 를 매칭시키는 메서드
     * @param requestURI
     * @return
     */
    private boolean isWhiteList(String requestURI) {
        return PatternMatchUtils.simpleMatch(WHITE_LIST, requestURI);
    }
}
