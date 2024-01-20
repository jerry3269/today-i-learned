### 서버인증(3) - OAuth2.0

#### 1. OAuth 란?

OAuth는 외부서비스의 인증 및 권한부여를 관리하는 범용적인 프로토콜이다.

* **권한**: OAuth는 인증뿐 아니라 권한 관리도 한다.

* **프로토콜**: 일종의 규격이다. SNS로그인을 제공하는 Facebook, Google등은 OAuth 규격에 맞춰 인증 및 권한을 대행 관리 한다.

* **외부서비스**: 우리가 만드는 서비스를 의미한다.
  
  <br>

> 주의할점!

* SNS로그인 기능을 넣더라도 세션/쿠키 혹은 토큰을 사용한 인증을 거쳐야 한다.

<br>

---

#### 2. OAuth 1.0 -> OAuth 2.0

2007년 OAuth 1.0이 발표되었고 많은 사람들의 관심을 받았다. 하지만 커저가는 네트워크 시장에서 한계가 나타나기 시작했고 2012년 OAuth 2.0이 등장하게 되었다. 

OAuth 2.0에서 크게 바뀐 점은 다음과 같다.

* 모바일에서도 사용이 용이해짐.

* HTTPS만을 사용하여 보안이 강화됨.

* Access Token 만료기간이 생김.

<br>

---

#### 3. 인증방식

OAuth 2.0의 인증방식은 크게 4가지가 있다. 

그중이 우리는 1번 Authorization Code Grant을 살펴볼 것이다.

* **Authorization Code Grant**

* Implicit Grant

* Resource Owner Password Credentials Grant

* Client Credentials Grant

<br>

---

#### 4. Authorization Code Grant

* **Resource Owner**: 일반 사용자를 의미한다.

* **Client**: 우리가 관리하는 서버를 의미한다.

* **Authorization Server**: 권한을 관리하는 서버이다.(토큰 발급, 재발급을 해주는 역할)

* **Resouce Server**: OAuth2.0을 관리하는 서버(Google, Facebook 등)의 자원을 관리하는 서버를 의미한다.

<br>

##### 4-1. 동작방식

![](C:\Users\jerry\AppData\Roaming\marktext\images\2023-10-18-17-28-42-image.png)

* **Authorization Server**: 인증 + 권한 관리만을 담당한다.

* **Resouce Server**: 자원에 대한 관리만을 담당한다.

<br>

---

#### 5. SNS 로그인

SNS로그인은 모두 OAuth 2.0 프레임워크를 통해 로그인 API를 제공공한다.

<Br>

##### 5-1. 페이스북 로그인의 동작과정

![](C:\Users\jerry\AppData\Roaming\marktext\images\2023-10-18-17-35-26-image.png)

* 위와 같이 동작하고 로그인이 완료되었다면 세션/쿠키, 토큰 기반 인증방식을 통해 사용자 인증을 처리한다.

* 페이스북 로그인의 경우 Resource Server를 사용하지 않는다. 따라서 발급받은 토큰이 실제로 쓰이지 않고, 서버에서 검증할 수도 없다.

* 따라서, 보통 Authorization Server로부터 얻은 고유Id(회원 ID)나 프로필을 통해 회원 DB에 저장 및 DB관리를 하게된다. 

* 이후 서버에서 쿠키/세션 이나 토큰을 기반으로한 인증을 추가적으로 진행하여 인증된 사용자임을 판단한다.

<br>

> 장점

* 사용자 입장에서 회원가입절차를 생략하여 빠르게 회원가입할 수 있다.

* 접근하고 싶은 정보들을 사용자들이 선택하여 동의하기 때문에 쉽게 접근 할 수 있다.

<br>

---

#OAuth    #SNS로그인    #서버인증
