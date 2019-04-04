# kogile(업무협업툴)
첨부파일 : kogile파이널.pdf

## 구현내용

### 로그인, 회원가입
![kogile](./MDimages/kogile_project26.png)

![kogile](./MDimages/kogile_project27.png)
- 카카오 로그인 및 회원가입이 가능하다.

### 프로젝트
![kogile](./MDimages/kogile_project28.png)

![kogile](./MDimages/kogile_project38.png)
- 로그인된 아이디가 참가하고 있는 프로젝트 목록을 보여준다.
- 생성할 수 있다.
- 프로젝트의 정보를 확인, 수정, 삭제할 수 있다.
### 포스트 이동
![kogile](./MDimages/kogile_project29.png)

![kogile](./MDimages/kogile_project38.png)

- 해당 작업을 이동할 수 있다.
- DB에도 반영된다.

### 체크리스트
![kogile](./MDimages/kogile_project30.png)

![kogile](./MDimages/kogile_project31.png)

![kogile](./MDimages/kogile_project32.png)
- 상세보기에서 체크리스트를 추가할 수 있다.
- 체크리스트에 리스트를 추가 할 수 있다.
- 체크된 작업을 계산하여 완성률을 보여준다.   
(모달창과 상세보기 페이지 모두에서 확인 가능하다.)

### 라벨
![kogile](./MDimages/kogile_project33.png)
- 프로젝트 생성 시, 각 칼라별 라벨이 기본적으로 생성된다.(4개)
- 라벨을 추가할 수 있다.(프로젝트 별)
- 라벨을 클릭 시, 라벨을 가시적으로 표현할 수 있다.   
(모달창과 상세보기 페이지 모두에서 확인 가능하다.)

### 마감일
![kogile](./MDimages/kogile_project34.png)
![kogile](./MDimages/kogile_project35.png)
- 마감일을 등록할 수 있다.
- 삭제, 수정이 가능하다.
- 메인 화면에서 D-day까지 남은일을 확인 할 수 있다.

### 공지사항
![kogile](./MDimages/kogile_project36.png)
![kogile](./MDimages/kogile_project37.png)
- 기본적인 게시판을 구현하였다. (프로젝트 별 소유)

### 검색
![kogile](./MDimages/kogile_project39.png)

![kogile](./MDimages/kogile_project40.png)

![kogile](./MDimages/kogile_project41.png)

![kogile](./MDimages/kogile_project43.png)
- 프로젝트 및 회원을 검색할 수 있다.
- 프로젝트를 클릭 시, 해당 프로젝트로 이동한다.
- 회원을 클릭 시, 해당 회원을 현재 프로젝트에 초대한다.
- 초대된 회원은 알림이 발생한다.

### 댓글(태그) 및 알림
![kogile](./MDimages/kogile_project44.png)
![kogile](./MDimages/kogile_project45.png)
- 댓글 등록 후, 태그 input란에 현 프로젝트원을 입력 시, 자동완성이 된다.
- 태그된 회원은 알림이 발생한다.
- 확인한 알림은 확인상태로 변경된다.