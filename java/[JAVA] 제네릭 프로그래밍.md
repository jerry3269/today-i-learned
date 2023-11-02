# 제네릭 프로그래밍

스프링을 하다가 제네릭 타입을 마주쳤는데 기억이 가물가물하여 다시 정리해 보았다..

<br><Br>

# 1. 클래스 제네릭 타입

자바에서는 Object가 모든 객체의 최상위 클래스이다.
즉, Object객체는 모든 인스턴스 객체를 받을 수 있다.

<br><Br>

## 1) 쓰임

제네릭 클래스가 쓰이는 곳을 알아보자.

```java
public class ThreeDPrinter{

}
```

다음과 같이 3D프린터가 있다고 가정해보자.

<br><Br>

3D프린터는 플라스틱과 파우더를 재료로 쓸 수 있다.

<br><Br>

두개의 재료를 사용하는 프린터는 다음과 같이 만들어야 할까?

```java
public class ThreeDPrinter{
    private Powder powder;
    private Plastic plastic;
}
```

<br><Br>

하지만 만약 플라스틱만을 사용하는 제품을 만들때는 파우더라는 필드가 필요가 없어진다.

그럴때 제네릭 타입을 사용한다.

<br><Br>

```java
public class ThreeDPrinter{
    private Object material; 
}
```

이것은 제네릭 타입이 아니라 단순히 오브젝트로 모든 인스턴스를 받을수 있게 만든것이다.

<br><Br>

제네릭 타입은 다음과 같이 사용한다.

```java
public class ThreeDPrinter<T>{
    private T material;
}
```

T는 Object를 다르게 표현한것으로, Object와 같이 여러 타입을 인스턴스로 받을 수 있다.

<br><Br>

여기서 클래스 이름옆에 `<T>` 를 볼 수 있는데 이 표현의 의미는 
해당 클래스에서 여러 타입을 받는 변수로 `T`를 사용하겠다는 의미이다.

<br><Br>

하지만 여기서 문제가 발생한다.

<br><Br>

바로 프린터의 재료가 `물`로 들어온다면 어떻게 될까?

<br><Br>

제네릭 타입은 모든 타입을 받을 수 있기 때문에 물로 재료를 받아도 아무런 예외가 발생하지 않는다.

<br><Br>

그렇다면 T에 올수 있는 타입을 제한해야한다.

<br><Br>

여기서 바로 상속관계를 이용한다.

<br><Br>

다음과 같은 클래스를 만들고

```java
public class Material{

}
```

<br><Br>

플라스틱과 파우더 클래스가 Material을 상속한다.

```java
public class Plastic extends Material{

}
```

```java
public class Powder extends Material{

}
```

<br><Br>

파우더와 플라스틱이 Material을 상속하게 되면 
3D프린터에 다음과 같은 제약을 넣는다.

```java
public class ThreeDPrinter<T extends Material> {
    private T material;
}
```

`T extends Material`은 `T`가 `Material`클래스를 상속하는 관계여야 T의 인스턴스 객체로 받을 수 있다는 것을 의미한다.

<br><Br>

이렇게 설정하면 

```java
TreeDPrinter<Water> printer  = new ...
```

다음과 같은 생성에서 바로 예외가 발생한다.

<br><Br>

물론 상위 클래스와 하위클래스가 기존에 가졌던 특징은 모두 가진다.
메소드 오버라이딩, 추상클래스 구현 책임 등.

<br><Br>

제네릭 타입은 여러개로 설정 할 수 있다.

```java
public class Controller<T,S>{
    private T data;
    private S string;
}
```

<br><Br>

# 2. 메소드 제네릭 타입

지금까지는 클래스에서 제네릭 타입을 쓰는 것을 알아보았다.

<br><Br>

이제는 메소드에서 제네릭 타입을 쓰는 방법을 알아 보겠다.

```java
public static <T, V> double update(Point<T,V> p1, Point<T,V> p2){
    ...
}
```

다음과 같이 사용할 수 있다.

여기서 알 수 있는 점은 Point라는 클래스가 있고, 해당 클래스는 <T,V>라는 제네릭 변수 2개를 사용한다는 것이다.

여기서 주의 할 점은 `double`앞에 있는 <T,V> 이다.

<br><Br>

클래스는 해당 클래스 에서 사용되는 제네릭 타입을 클래스 이름 뒤에 적어주었다.

<br><Br>

메서드에서는 해당 메서드 안에서 사용되는 제네릭 타입을 반환타입 앞에 적어주어야 한다.

여기서는 `double`이 반환타입 이므로 double앞에 사용하는 제네릭 타입을 적어 주었다.

<br><Br>

제네릭 타입은 자바 5버전에 나온 기능으로, 지금까지도 많이 사용된다.
