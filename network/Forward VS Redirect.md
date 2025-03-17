### Forward VS Redirect

#### 1. Forward 방식

```java
@GetMapping("/")  
public String root() {  
 return "forward:/articles";  
}
```

Forward는 Web Container(서버) 차원에서의 페이지 이동만이 존재한다. 따라서<mark> 웹 브라우저는 최초에 호출한 URL이 표시</mark>되고, <mark>이동한 페이지의 URL 정보는 알 수 없다</mark>. 또한 현재 실행중인 페이지와 Forward에 의해 호출될 페이지는 <mark>Request와 Response 객체를 공유</mark>한다.



위의 컨트롤러에 GET URL 요청을 보낸다고 가정해보자. 

그렇다면 실제 페이지는 **`/articles`** 가 호출될 것이다.

하지만 클라이언트에게 보여지는 URL은 여전히 **`/`** 인것이다.

즉, 해당 방식은 클라이언트가 **`/`** URL에만 요청을 보낸다. 페이지 이동은 서버 사이드에서 벌어지는 일인 것이다.



#### 2. Redirect 방식

```java
@GetMapping("/")  
public String root() {  
 return "redirect:/articles";  
}
```

Redirect는 Web Container로 명령이 들어오면 웹브라우저에게 다른 페이지로 이동하도록 Response를 보낸다. . 그러면 웹 브라우저가 해당 주소로 다시 URL 요청을 하는 것을 의미한다. 이때 <mark> 새로운 페이지의 Request와 Response 는 새롭게 생성</mark>된다.



위의 컨트롤러로 GET URL 요청을 보낸다고 가정해보자.

그렇다면 **`/`** 로 맨 처음 요청이 가게되고, 

서버에서 **`/articles`** 로 Redirect하라고 Response를 보낸다.

클라이언트가 다시 **`/articles`** 로 요청을 보내게 된다.

즉, 해당 방식은 클라이언트가 **`/`** 와 **`/articles`** 에 각각 요청을 보낸다. 



#### 3. 언제 무슨 방식을 써야 할까?

두 방식 모두 사용자가 요청한 URL 페이지가 아닌 다른 페이지를 보여주기 위한 페이지 전환 

기능이다. 



클라이언트가 요청한 페이지를 URL1, 이동된 페이지를 URL2라고 했을 때,

<mark>Forward와 Redirect의 명확한 차이는 바로 Request와 Response 객체를 URL1과 URL2가 </mark>

<mark>공유하느냐의 차이이다. Foward는 공유하고 Redirect는 공유하지 않는다.</mark>

이 차이로 언제써야하는지가 나뉜다.



클라이언트가 상품을 주문하는 요청을 보냈다고 가정해보자.

Forward를 사용한다면 Request와 Response객체를 공유하기 때문에 페이지를 새로고침하

게 되면 해당 요청이 여러번 보내지게된다. 

반면에 Redirect사용한다면, 새로고침을 했을 때, 바로 직전의 요청이 주문한 요청이 아닌 새

로운 페이지로 Redirect하는 요청이 되어서 주문 요청이 반복되지 않는다. 



정리해보자면, <mark>Forward는 단순조회(GET 요청)에서 사용하고, Redirect는 데이터에 변화가</mark>

<mark>생기는 요청의 경우에 사용</mark>해야 한다.




