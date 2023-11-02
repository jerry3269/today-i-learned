# 자바 스트림
자바 스트림은 자바 8에서 기능이 추가 되었다.

<br><Br>

람다를 활용한 기술이며, 배열 혹은 컬렉션에 대한 루프를 돌면서 여러개를 조합하여 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있다.

<br><Br>

루프문을 쓰지 않아도 되어서 코드의 양이 매우 줄었고, 매우 자주 사용하는 기술 중 하나이다.

# 스트림
스트림은 3가지의 순서로 나타낼수 있다.

- 1. 생성하기
- 2. 가공하기
- 3. 결과얻기

<br><Br>

## 1) 생성하기

### 배열인 경우

<br><Br>

배열인 경우에는 다음과 같이 스트림을 생성해야 한다.

```java
String[] arr = new String[]{"a", "b", "c"};
Stream<String> stream1 = Arrays.stream(arr);

Stream<String> stream2 = Arrays.stream(arr, 1, 3); //1~2요소
```

<br><Br>

### 컬렉션인 경우

<br><Br>

컬렉션인 경우 다음과 같이 스트림을 생성한다.

```java
List<String> list = Arrays.asList("a", "b", "c");
Stream<String> stream = list.stream();
Stream<String> parallelStream = list.parallelStream(); // 병렬 처리 스트림
```


<br><Br>

## 2) 가공하기


<br><Br>

### 1) Filtering
말 그대로 스트림내 요소들을 걸러내는 기능이다.

```java
Stream<String> stream = names.stream()
                    .filter(name -> name.contains("a"));
```

<br><Br>

### 2) Mapping
스트림 내 요소들을 하나씩 돌아가면서 특정 값으로 변환해주는 기능이다.
스트림 요소들을 람다의 인자로 받는다.

```java
Stream<String> stream = names.stream()
                        .map(s -> s.toUpperCase);
```

<Br><Br>

### 3) Sorting
스트림 내 요소들을 정렬한다.
다른 정렬 방법과 마찬가지로 Comparator를 이용한다.

```java
lang.stream()
  .sorted((s1, s2) -> s2.length() - s1.length())
  .collect(Collectors.toList());
```

<br><Br>

## 3. 결과 만들기

### 1) Collectors.toList()
스트림에서 작업한 결과를 리스트롤 담아 반환.

```java
List<String> collectorCollection =
  productList.stream()
    .map(Product::getName)
    .collect(Collectors.toList());
```

<br><Br>

### 2) Collectors.joining()
스트림에서 작업한 결과를 하나의 스트링으로 이어 붙인다.

```java
String listToString = 
 productList.stream()
  .map(Product::getName)
  .collect(Collectors.joining());
```

<br><Br>


이외에도 여러가지 스트림의 기능이 많은데 다음 글을 참고하자.

https://futurecreator.github.io/2018/08/26/java-8-streams/



