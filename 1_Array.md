2025년 8월 27일 수요일

<img width="604" height="453" alt="image" src="https://github.com/user-attachments/assets/08a80b99-ca12-4f03-b8d1-0887f3dcda3e" />


케이스타에서 하는 이것이 자바다 저자인 임경균 교수님이 직접 강의 하는 
생성형AI활용 MSA기반 Full Stack 개발자 양성과정에 입과하였다. 

김포에서 송파까지 최소 1시간 45분 걸리는 거리라서 
아침 7시에 출발하였는데도 아슬아슬하게 도착했다. 
직장인들의 출근길 고충을 이해할 수 있으면서도 나도 속해진 기분이라 좋기도 했다. 

수업은 8월 18일부터 시작되었고, 나는 3차 모집자로 8번째 날에 합류하게 된 터라 
지나간 커리큘럼에 대한 걱정과 기대감으로 수업을 들었다. 

## 코드 리뷰
아마도 어제의 과제는 로또 만들기였던지, 제출한 과제들을 살펴보시며 코드 리뷰를 해주셨다. 
복잡한 코드가 멋있어 보이더라도, 논리가 단순한 코드가 더 좋다고 말씀하셨다. 
내가 스스로 코드를 작성한 후 챗GPT에게 코드 리뷰를 받는 것이 도움이 된다고도 하셨다. 

또한 FileReader를 사용할 때는 try문 안에서 객체를 생성해 사용하면 된다고 알려주셨다. 
IO 작업은 메모리에 직접 접근하는 매우 느린 작업이며, 가비지 컬렉터가 관리하지 않는 자원이기 때문에 개발자가 직접 close(); 같은 코드로 자원을 정리해야 한다. 
하지만 try문에 객체를 넣어 사용하면 블록이 끝나는 순간 자동으로 닫히므로, 이를 활용하는 것이 편리하다는 팁을 주셨다. 
Scanner와 BufferedReader 같은 IO 작업에서도 같은 방식으로 활용할 수 있다고 하셨다. 

## 메모리 저장 영역
값 배열은 힙 메모리에, 참조변수는 스택에 저장되므로 
```java
Dog[] pets = New Dog[7];
pets[0] = 객체

Stack
 └─ pets ────────┐
                  │
Heap              │
 ┌─────────────┐  │
 │ Dog[7]      │◄─┘
 │ [0] ──▶ Dog 객체
 │ [1] null
 │ [2] null
 │ ...
 │ [6] null
 └─────────────┘
```
Dog[] pets → 배열 변수 pets는 스택에 저장되고,
길이 7짜리 배열은 힙에 생성된다.
즉, pets라는 참조변수(배열 주소)가 스택에, 배열(7칸)은 힙에 저장된다.
새로 만들어진 객체도 힙에 저장되어 있으며 pets[0]이 그 객체를 참조하고 있다.

## Java 배열과 메서드 호출(Stack/Heap) 이해하기

Java에서 배열은 객체이며, 메서드로 전달될 때 참조(주소)가 전달된다.

```java
public class OverClass {
    public int[] add(int[] params) {
        int[] result = new int[params.length];
        for (int i = 0; i < params.length; i++) {
            result[i] = params[i] + 1; // 예시: 모든 값에 1 더하기
        }
        return result;
    }

    public static void main(String[] args) {
        OverClass overClass = new OverClass();
        int[] source = {10,20,30,40,50};
        int[] result = overClass.add(source);

        for(int num : result) {
            System.out.print(num + " "); // 11,12,13,14,15
        }
    }
}
```

1. 호출 전 상태
```
Stack
 └─ source ──▶ int[5] {10,20,30,40,50}
Heap
 └─ int[5] {10,20,30,40,50}
```

2. add(source) 호출 시
스택에 add() 프레임 생성되고, 매개변수 params → source 배열 참조하며, 힙에 새 배열 result 생성
```
Stack
 ├─ add() frame
 │   └─ params ──▶ source 배열

Heap
 ├─ source 배열 {10,20,30,40,50}
 └─ result 배열 {11,21,31,41,51}

```
3. add() 종료 후 반환
add() 스택 프레임 제거되고, 반환된 배열 주소가 Stack의 result 변수에 할당됨.
```
Stack
 ├─ source ──▶ source 배열
 └─ result ──▶ result 배열

Heap
 ├─ source 배열 {10,20,30,40,50}
 └─ result 배열 {11,21,31,41,51}
```
## 다차원 배열 (교재의 167p ~ 195p) 

프로그래밍에서 "다차원 배열"이라고 하지만 실제로는 2차원 배열이 가장 많이 사용된다.
2차원 배열은 행(row) 과 열(column) 로 이루어져 있으며,
일상생활에서도 쉽게 찾아볼 수 있다. 
Ex : 엑셀 시트, 오목판, 영화 좌석표, 지도 위·경도 좌표
이처럼 행과 열로 표현할 수 있는 데이터를 다룰 때 2차원 배열이 유용하다.

만약 열이 똑같지 않다면 가변배열인데 코드로 구현하려면
```java
int[][] arr = new int[4][];
arr[0] = new int[2];
arr[1] = new int[3];
arr[2] = new int[1];
arr[3] = new int[4]; // 예시로 4개 추가

Stack
 └─ arr ────────────▶ int[4][] 배열 (Heap)

Heap
 ┌───────────────────────────┐
 │ int[4][]                  │
 │ [0] ──▶ int[2] {0,0}      │
 │ [1] ──▶ int[3] {0,0,0}    │
 │ [2] ──▶ int[1] {0}        │
 │ [3] ──▶ int[4] {0,0,0,0}  │
 └───────────────────────────┘
```

## lombok 롬복
롬복(Lombok) 은 반복적으로 작성해야 하는 코드를 자동으로 생성해주는 라이브러리이다.

만약 지금 작성하는 코드가 10년 뒤에도 동일한 형태로 유지된다면, 그 코드는 오히려 사라질 가능성이 높다. 
왜냐하면 컴파일러와 언어 자체는 개발자의 편리함을 높이는 방향으로 발전하기 때문이다. 

하지만 자바는 여전히 다음과 같은 부분을 공식적으로 간편하게 지원하지 않는다: 
- 클래스의 getter(), setter() 자동 생성 
- static inner class Builder 를 활용한 빌더 패턴 지원 

따라서 롬복을 사용하면 
- @Getter, @Setter, @Builder 등 어노테이션만으로 반복 코드를 줄일 수 있다. 
- 빌더 패턴을 간단히 구현하여 객체 생성 시 필요한 값을 명확하게 지정할 수 있다. 
참고로 `@`로 시작하는 애너테이션은 컴퓨터에 지시하는 역할을 한다. 

즉, 롬복은 자바에서 객체 생성과 캡슐화 작업을 간편화해주는 도구라고 할 수 있다. 

```java
import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Member {
    private String name;
    private String job;
    private String hobby; // 필드 이름이 builder 메서드 이름이 됨

    public static void main(String[] args) {
        Member member = Member.builder()
                              .name("sohee")
                              .job("backend-Dev")
                              .hobby("coding")
                              .build();
        System.out.println(member);
    }
}
```

# 상속 (Inheritance)
하나의 클래스로만 프로젝트를 만들 수는 없다.
우리는 여러 클래스들을 모아서 하나의 큰 클래스를 만들어야 한다.
큰 클래스를 이루는 작은 클래스(설계도)들은 4개로 나눈다면 아래와 같다.

1. 메인 설계도 : 전체 시스템의 핵심이 되는 클래스
2. 부분 설계도 : 메인 클래스를 구성하는 보조 클래스
3. 독립적인 별도의 설계도 :  다른 클래스와 독립적으로 동작하는 클래스
4. 메인 설계도의 하위 설계도 : 메인 클래스로부터 상속받는 자식 클래스

여러개의 클래스 중에 어떤 관계에 따라 상속을 정할 텐데, 그 기준으로 자주 쓰이는 방법이 ~ is a ~ : ~는 ~이다 기법이다.
예를 들어 "원은 도형이다"라고 말해도 맞는 말이라면, 부모는 도형, 원은 자식이 될 수 있다고 보는 것이다.

- 자동차는 교통수단이다 (상속)
- 개는 동물이다 (상속)


반면에 has ~ a는 "~이 ~을 가지고 있다"라고 표현된다면 이것은 상속관계가 아닌 포함관계로서 부품으로 가질 수 있도록 멤버 필드에 포함하면 된다.
예를 들어:

- 차는 엔진이다 (상속)
- 차는 엔진을 가지고 있다 (포함)

### 상속을 선언하는 방법
자바에서는 `child extends Base` C#에서는 `child : base`이다.

### 상속의 특징
자바에서는 단일 상속 원칙이 있어서 여러 부모를 두는 다중상속이 불가하다.


## 오늘의 과제
- 버블정렬을 짤 수 있다.
- (버블정렬이 실무에선 느리기 때문에 잘 쓰이지 않지만, 개발자의 역량 체크에 쓰이기 때문에 내주신 것 같다.)
- 네이버 카페에 자기소개하기
- 영화관 과제 (미완)
- git 조별 과제 (토요일까지)

## 내일 배울 것
super, 오버라이딩, fanal, 접근제어자 protected, 다형성
