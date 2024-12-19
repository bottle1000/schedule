-- User 테이블 생성
CREATE TABLE user
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    username   VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    password   VARCHAR(255)        NOT NULL,
    created_at DATE                NOT NULL,
    updated_at DATE
);

-- Schedule 테이블 생성
CREATE TABLE schedule
(
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id    BIGINT       NOT NULL,
    title      VARCHAR(255) NOT NULL,
    content    TEXT         NOT NULL,
    created_at DATE         NOT NULL,
    updated_at DATE,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
);

-- Comment 테이블 생성
CREATE TABLE comment
(
    id              BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id         BIGINT NOT NULL,
    schedule_id     BIGINT NOT NULL,
    comment_content TEXT   NOT NULL,
    created_at      DATE   NOT NULL,
    updated_at      DATE,
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (schedule_id) REFERENCES schedule (id) ON DELETE CASCADE
);