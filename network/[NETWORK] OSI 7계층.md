### OSI 7계층

<img src="https://camo.githubusercontent.com/44fe40125073c05a22961a70ae08c4e0b6b2bf5bfbd11f5ab9135e2a683241a7/68747470733a2f2f73373238302e7063646e2e636f2f77702d636f6e74656e742f75706c6f6164732f323031382f30362f6f73692d6d6f64656c2d372d6c61796572732d312e706e67" title="" alt="" width="378">

(Open Sysyems InterConnection Reference Model)의 약자로, 네트워크에서 통신이 일어나는 과정을 7단계로 나눈 것이다.

<Br>

#### 1. Physical

```textile
데이터 단위: bit
```

> 리피터 , 케이블, 허브

* 장치간 <mark>전기적 신호</mark>를 전달하는 계층이며, 데이터 프레임 내부의 각 bit를 한 노드에서 다음 노드로 실제 이동시키는 계층이다.

<br>

#### 2. Data Link

```textile
데이터 단위: frame
```



> 브릿지, 스위치

- 데이터를 <mark>frame</mark> 단위로 한 네트워크 요소에서 이웃 네트워크 요소로 전송하는 계층이다.

- 인터넷은 <mark>Ehternet</mark> 프로토콜이 대표적이다. Ethernet은 <mark>Mac</mark> 주소를 통해 통신한다. 프레임에 Mac 주소를 부여하고 Node-to-Node, Point-to-Point로 frame을 전송한다.

- Physical layer에서 발생할 수 있는 오류검출, 재전송, 흐름제어를 담당한다.

<br>

#### 3. Network

```textile
데이터 단위: packet
```

> 라우터, IP

* 여러개의 노드를 거칠때마다 경로를 찾아주는 역할(라우팅)을 한다.

* Transport layer에서 전달받은 목적기 주소를 이용하여 패킷을 만들고 그 목적지의 Transport layer로 패킷을 전달한다.

<br>

#### 4. Transport

```textile
데이터 단위: segment(TCP)/datagram(UDP)
```

> TCP, UDP

* 보내고자 하는 데이터의 용량, 속도, 목적지를 처리한다.

* TCP는 세그먼트를 작은 패킷으로 나눠 여러 경로를 통해 데이터를 전송하고 목적지에서 순서대로 패킷을 조립하여 데이터를 전달한다.

* 데이터그램은 순서에 상관없이 데이터를 전달하기때문에 신뢰성을 보장하지 않는다.

<br>

#### 5. Session

> Socket, API

* 실제 네트워크 연결이 이루어진다. 두대의 기기가 '대화'되기 위해서는 하나의 '세션'이 열려야 한다.

* 프로세스간의 통신을 제어하고, 통신과정이 진행될 때 동기화를 유지하는 역할을 한다.

* 전이중(동시에 보냄, 전화기), 반이중(동시에 보내지 않음, 무전기), 동시 송수신 방식을 결정한다.

* TCP/IP 세션을 만들고 없애는 책임을 진다.

<Br>

#### 6. Presentation

> JPEG, MPEG

* 응용프로그램 데이터 <-> 네트워크 데이터 간의 변환을 표현하는 계층이다.

* 데이터를 안전하게 주고 받기 위해 암호화하고 복호화하는 과정이 이루어진다.

<br>

#### 7. Application

> HTTP, DNS, SMTP

* 통신의 최종 목적지로, 네트워크에 접근할 수 있도록 인터페이스를 제공하는 계층이다.

<br>

![](C:\Users\jerry\AppData\Roaming\marktext\images\2023-11-02-12-26-34-image.png)
