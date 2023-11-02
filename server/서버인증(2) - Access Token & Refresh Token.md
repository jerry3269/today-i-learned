### 서버인증(2) - Access Token & Refresh Token

기존 `JWT`방식은 Access Token이 탈취당하게 되면 토큰을 조작하여 다른 사용자인 것처럼 할 순 없지만, **탈취당한 토큰의 주인 행세**는 할 수 있었다. 

이러한 점을 보완하기 위해 JWT의 강화버전인 **Access Token & Refresh Token**이 등장하였다.

<br>

* 사용자가 **로그인 성공 시 Access Token, Refresh Token을 발급**한다. 

* Access Token은 탈취방지를 위해 **유효기간을 짧게 설정**하고, **Refresh Token은 길게 설정**한다.

* 이때, Refresh Token은 일반적으로 회원 DB에 같이 저장한다.

* 두 개의 토큰을 받은 사용자는 Refresh Token은 안전한 저장소에 저장하고, Access Token을 헤더에 실어 요청을 보낸다.

* **Access Token이 유효하다면 서버에서는 사용자의 요청을 처리**한다.

* **Access Token이 만료**되었다면, **서버는 권한없음(401)을 응답**하고, 이를 받은 사용자는 **Access Token과 Refresh Token을 함께 서버**로 보낸다.

* 서버는 Access Token이 조작되지 않았는지 확인 후, **Refresh Token과 사용자의 DB에 저장되어 있던 Refresh Token을 비교**한다.

* Token이 동일하고 유효기간이 남았다면 **새로운 Access Token을 발급**해준다.

* 서버는 발급한 Access Token을 헤더에 실어 다시 API 요청을 진행한다.

<br>

> 장점

* Access Token의 유효기간을 짧게 설정하여 탈취당하더라도 토큰이 빨리 만료될 수 있도록 한다.

<br>


> 단점

- 구현이 복잡해지고, **Access Token 만료시 새롭게 발급하는 과정에서 HTTP 요청 횟수가 많아진다**.

- 회원 도메인에 Refresh Token을 넣거나, Refresh Token저장소를 서버에서 마련해야 한다.

- **Access Token의 유효기간이 남아있다면, 로그아웃을 하여도 여전히 사용할 수 있고 탈취의 문제도 존재**한다.

<br>

#Access Token&Refresh Token    #JWT    #서버인증
