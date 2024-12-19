# 일정 관리 프로그램
````
일정 관리 프로그램은 Java와 Spring Boot 기반의 일정 관리 시스템입니다.
사용자는 다음과 같은 기능을 RESTful API를 통해 사용할 수 있습니다.

* 일정 관리
* 사용자 관리
* 댓글 관리
````
---

## API 명세서

### 기본 URL
````
http://localhost:8080
````
---

### 1. 일정 관리 API

#### 모든 일정 조회
- **URL**: `GET /schedule`
- **응답**:
```json
  {
    "content": [
      {
        "title": "회의",
        "content": "프로젝트 회의 진행",
        "commentCount": 2,
        "createdAt": "2024-12-01",
        "updatedAt": "2024-12-02",
        "username": "박병천"
      }
    ],
    "pageable": {...},
    "totalPages": 1
  }
```
#### 일정 생성
- **URL**: `POST /schedule`
- **요청**:
```json
{
  "title": "회의",
  "content": "프로젝트 회의 진행"
}
```
- **응답**:
```json
{
  "title": "회의",
  "content": "프로젝트 회의 진행"
}
```

#### 특정 일정 조회
- **URL**: `POST /schedule/{id}`
- **응답**:
```json
{
  "title": "회의",
  "content": "프로젝트 회의 진행"
}
```
#### 일정 수정
- **URL**: `PUT /schedule/{id}`
- **요청**
```json
{
  "content": "수정된 일정"
}
```
- **응답 상태** : 200 OK

#### 일정 삭제
- **URL**: `DELETE /schedule/{id}`
- **응답 상태** : 200 OK

---

### 2. 사용자 관리 API

#### 사용자 생성(회원가입)
- **URL**: `POST /user/signup`
- **요청 본문**:
```json
{
  "username": "user",
  "email": "user@example.com",
  "password": "1234"
}
```
- **응답** :
```json
{
  "username": "user",
  "email": "user@example.com"
}
```
#### 사용자 로그인
- **URL**: `POST /user/login`
- **요청 본문**:
```json
{
  "email": "user@example.com",
  "password": "1234"
}
```
- **응답** :
```json
{
  "id" : 1
}
```
#### 사용자 전체 조회
- **URL**: `GET /user`
- **응답**:
```json
[
    {
      "username": "user",
      "email": "user@example.com"
    },
    {
      "username": "newUser",
      "email": "newUser@example.com"
    }
]
```

#### 특정 사용자 조회
- **URL**: `GET /user/{id}`
- **응답**:
```json
{
  "username": "user",
  "email": "user@example.com"
}
```
#### 사용자 삭제
- **URL**: `DELETE /user/{id}`
- **응답 상태**: 200 OK

---

### 3. 댓글 관리 API

#### 특정 일정의 댓글 조회
- **URL**: `GET /schedule/{scheduleId}/comment`
- **요청 파라미터**:
    - `scheduleId` (Path Variable): 조회할 일정의 ID
- **응답**:
```json
{
    "comments": [
      {
        "id": 1,
        "content": "좋은 일정입니다.",
        "author": "user1"
      },
      {
        "id": 2,
        "content": "멋진 계획이네요.",
        "author": "user2"
      }
    ]
}
```

#### 댓글 생성

- **URL**: `POST /schedule/{scheduleId}/comment`
- **요청 파라미터**:
  - `scheduleId` (Path Variable): 댓글을 추가할 일정의 ID
- **요청 본문**:
```json
{
  "content": "좋은 일정입니다."
}
```
- **응답**:
```json
{
  "id": 1,
  "scheduleId": 1,
  "content": "좋은 일정입니다.",
  "author": "user1"
}
```

#### 댓글 수정

- **URL**: `PUT /schedule/{scheduleId}/comment/{commentId}`
- **요청 파라미터**:
  - `scheduleId` (Path Variable): 댓글을 추가할 일정의 ID
  - `commentID` (Path Variable) : 수정할 댓글의 ID
- **요청 본문**:
```json
{
  "updateContent": "수정된 댓글 내용"
}
```
- **응답 상태**: 200 OK

#### 댓글 삭제

- **URL**: `DELETE /schedule/{scheduleId}/comment/{commentId}`
- **요청 파라미터**:
  - `scheduleId` (Path Variable): 댓글이 속한 일정의 ID
  - `commentID` (Path Variable) : 삭제할 댓글의 ID
- **응답 상태**: 200 OK

---
# ERD
![scheduleERD](https://github.com/user-attachments/assets/759883c5-413a-4e4e-a521-722db4ed8050)


