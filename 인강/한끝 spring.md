# 한끝 Spring

##  IntelliJ 가이드

### ch01. 인텔리제이 시작하기
#### 01. 인텔리제이 설치하기
- 메모장만 있어도 코딩은 할 수 있음
- IDE가 여러가지 있지만 단축키, 디버깅, 테스트, 자동완성, GIT등의 이유로 인텔리제이 많이 사용
- 회사마다 IDE는 다름
- 학생용으로 IntelliJ를 다운받으면 ultimate를 설치할 수 있음

### ch02. 인텔리제이 단축키
#### 01. 단축키 기본 1
- 맥과 윈도우는 키보드가 달라서 단축키가 살짝 다를 수 있음
- 프로젝트 창(프로젝트 트리 보는 곳) 포커스 : alt + 1
- 프로젝트 창에서 에디터 창으로 돌아오기 : esc
- 프로젝트 창에서 미리보기 : space
- 에디터 창 키우기(최대화) : ctrl + shift + f12 -> 여러 창들이 다 켜져있을텐데 에디터를 제일 크게해서 코딩에 집중할 때 사용
- 에디터 창 이동 : ctrl + tab -> 여러 파일이 열려있을 때 파일간 이동
- 새파일 : 에디터에서 - ctrl + alt + insert , 프로젝트 창에서 - alt + insert
- 단어별 이동 : ctrl + 방향키
- 맨앞 맨뒤 : home, end
- 페이지 아래 위 : page up, page down
- 블록 주석 : shift + ctrl + /
- 들여쓰기 : tab
- 들여쓰기 취소 : shift + tab
- 자동 들여쓰기(pretty print) : ctrl + alt + i
- 사용처 찾기( 현재 클래스를 사용하고 있는 위치 빠르게 찾기 ) : alt + f7(빠른 찾기는 ctrl + b)
- 키워드를 통한 검색 : ctrl + shift + f
- 전체 검색(intellij 전체에서 검색) : shift 두번
- 최근 파일 열기 : ctrl + e(최근에 열었던 파일들의 목록을 보여주고 골라서 열 수 있음)

#### 02. 단축키 기본 2
- psvm : main 문 만들어줌
- sout : sysout을 만들어줌
- 퀵픽스(import 할 때 사용) : alt + enter
- 에러 단위로 이동 : 다음은 f2, 이전은 shift + f2
- import 최적화(필요없는 import 삭제) : ctrl + alt + o
- 코드 생성(getter, setter 등) : alt + ins
- overwrite : ctrl + o
- 터미널창 : alt + f12
- 구문 완성 : ctrl + shift + enter
- 파일 내 대체(찾아바꾸기) : ctrl + r
- run anything : ctrl + 2
- 실행 : shift + f10
- 파라미터 정보 : ctrl + p
- 선언부 확인 : ctrl + shift + i
- 기능 찾기 : shift + ctrl + a
- 단축키가 너무 많기때문에 다 외우기보다는 자주 쓰는것들만 익숙해지도록 하자

#### 03. 단축키 응용
- 기본편에서 기본적인 키를 알려줬음
- 테스트 코드
    - 테스트 코드 생성 : alt + enter
    - 테스트 코드를 생성하고 싶은 클래스에 커서를 놓고 하면 됨
    - 테스트 디렉토리에 테스트 코드 생성
    - 테스트 코드로 이동 : ctrl + shift + t
    - 테스트 코드 실행 : ctrl + shift + f10 (기존 실행 키랑 같음)
- 리펙토링
    - 클래스 이동 : f6(클래스를 다른 위치로 이동)
    - 클래스의 타입 변경 : ctrl + shift + f6
    - 시그니처 변경 : ctrl + f6
    - 변수의 이름 변경(사용하는 곳 한번에 모두 변경) : shift + f6
    - 리팩토링 : ctrl + alt + shift + t
    - 리팩토링 키 하나만 알아도 됌
- 디버깅
    - 브레이크 포인트 설정 : ctrl + f8
    - 브레이크 포인트 보기 : ctrl + shift + f8
    - 디버깅 모드 실행 : shift + f9
    - step into, step over : f8
    - 다음 브레이크 포인트로 이동 : f9
- git : alt + `
- 커스텀 단축키도 설정해줄 수 있음

### ch03. 인텔리제이 실습 - to do list 구현하기
#### 01. 요구사항 정리
- 필요 기능
    - todo 리스트 목록에 아이템 추가(post / 메소드를 통해 추가)
    - todo 리스트 목록 중 특정 아이템을 조회 (get /{id} 를 통해 조회)
    - todo 리스트 전체 목록을 조회(get / 메소드를 통해서 조회)
    - todo 리스트 목록 중 특정 아이템을 수정(patch /{id}를 통해 수정)
    - todo 리스트 목록 중 특정 아이템을 삭제(delete /{id}를 통해 삭제)
    - todo 리스트 전체 목록 삭제(delete / 를 통해 삭제)

#### 02. 환경설정 및 프로젝트 세팅(spring boot)
- build.gradle에서 해당 프로젝트에 필요한 gradle 설정
- plugins 에 사용할 플러그인 추가
```
plugins {
    id 'org.springframework.boot' version '2.4.2'
    id 'io.spring.dependency-management' version'1.0.11.RELEASE' // 스프링 부트 사용을 위한 플러그인
    id 'java'
}
```
- dependencies에 사용할 라이브러리 추가
```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'

    runtimeOnly 'com.h2database:h2' //라이브러리들 추가해줌    
    
    annotationProcessor("org.projectlombok:lombok")
    compileOnly("org.projectlombok:lombok") // 롬복 사용을 위한 추가
}
```
- gradle 새로고침하기
- plugins 에서 롬복 설치해줘야하며, annotaion processors 를 enable로 설정 해줘야함

#### 03. 모델 구현
- 레이어를 구분해서 각각의 레이어가 해당하는 일만 하도록 구현해줘야함
- 한번에 끝내는 spring/model 내에 있는 파일
    - TodoEntity.java : Entity 정의
    - TodoRequest.java : Request 정의
    - TodoResponse.java : Response 정의

#### 04. repository 구현
- repository는 데이터를 주고받는 인터페이스라고 보면 됨
- 한번에 끝내는 spring/repository 내에 있는 파일

#### 05. 서비스 코드 구현
- 서비스가 실제로 동작하는 코드 생성
- 한번에 끝내는 spring/service 내에 있는 파일

#### 06. 컨트롤러 구현
- 컨트롤러는 서버에서 작업하면서 어떤 작업을 수행하고 어떤 return을 주어줄지 구현하는 곳
- postman 사이트를 통해서 테스트를 할 수 있음
- 테스트 결과가 잘 넘어온것으로 확인할 수도 있고 돌려받는 값이 없는 경우에는 intellij에 로그를 찍어서 확인을 할 수 도 있다.
- 한번에 끝내는 spring/controller

### ch04. 리팩토링
#### 01. todolist 리팩토링
- 우리가 작성한 프로그램은 간단하니까 크게 리팩토링할 필요는 없음
- 예시로 하는 것
- package에 우클릭 후 refactor를 통해서 이름을 바꿔줄 수 있음(연관된 패키지 모두함께)
- 드래그를 통해서 다른 폴더로 클래스들을 옮겨줄 수 있음
- 로그를 System.out.println으로 하는 것보다 slf4j로 찍는게 좋음

### ch05. 디버깅
#### 01. 디버깅 이해
- 내가 작성한 코드의 문제를 찾는 과정
- 중단점 지정해놓고 디버깅 모드 실행해서 디버깅하면 됨
- step over, step into 등 다양한 진행 방식 존재
- 계산상의 문제가 생기는 위치도 찾을 수 있음

#### 02. 디버깅 실습
- 우리 실습 코드에 대한 디버깅임




## Part 1. Spring Framework
### ch01. 강의소개, 프로개발자로 성장하는 법
#### 01. 강의 소개 - 신입 개발자 키우기_01
- 강의는 쉽게 현업에서 자주 사용하는 내용으로 할 것

- 아 일요일은 공부 쉬는날이었다 ㅎㅎ

#### 02. 개발자의 소프트 스킬
- 이직을 위한 팁
    - 애매하게 아는 것을 경계해야함(이건 맞는 것 같다. 항상 면접에서 애매하게 아는 것 때문에 답변 못하는 경우가 생김)
    - 자신이 했던 업무, 프로젝트, 성과를 이 분야에 대해 전혀 모르는 사람에게 설명하는 연습을 해보는 것도 좋음
- 함께하고 싶은 개발자가 되는 방법
    - 개발자는 기획자나 현업 등 다양한 사람들이랑 일하는 일이 많이 생김(의사소통 능력 중요)
    - 애매한 것은 무조건 물어보고 질문이 오면 최선을 다해서 설명해주기(일을 해보니 친절한 사람이 평이 좋다)
    - 일정관리를 철저하게 해야한다(일이 많지만 일정을 잘 체크해야함) - 여러 툴들을 활용하면 좋음

#### 03. 개발자의 기초 체력을 키우는 방법
- 검색을 잘하는 실력을 키워야함(네이버 블로그에서 검색 ㄴㄴ 특히 라인 프렌즈 이모티콘 있는 블로그는 거른다)
    - 깃허브(ex.goodgid 깃허브) 같은 신뢰할 수 있는 사이트나 레퍼런스 사이트, 질의응답 사이트를 이용
    - 각 언어의 레퍼런스 사이트를 찾아보는게 제일 최신의 정확한 정보를 얻을 수 있음
    - 구글에서 검색할 때에도 영어로 검색하는 것이 좋으면 최대한 최신의 정보를 보는것이 좋음(기술이 너무 자주 바뀜)
- 에러코드를 읽는 방법을 연습하자
    - 코딩을 하면 에러를 많이 만날 것이다. 에러 메시지를 천천히 읽어보면서 어느 부분이 어떤 에러가 발생했는지 확인하는 연습을 해야한다
    - stack 형식으로 에러가 나오는 경우가 많은데 제일 위나 제일 아라부터 천천히 읽어보고 구글에 검색해보면 됨(회사에서도 jsp 개발할 때 보통 이 방법 사용)

#### 04. Intellij 소개 및 스프링 프로젝트 살펴보기
- 인텔리제이란
    - 인텔리제이는 유료, 검색기능이 굉장히 좋음(shift*2)
    - 생산성을 올려주는 좋은 툴이라고 생각(나도 아직 잘 못쓰지만 좋은 것 같음)
- 스프링 부트 프로젝트 쉽게 만드는 법
    - start.spring.io 사이트에 들어가면 내가 선택한 설정에 맞게 프로젝트 설정을 만들어줌(버전이나 설정 선택해주고 explore 누르면 코드로 나옴)
    - generate 누르면 자동으로 파일 다운로드 되서 실행 시 다른 최초 설정 필요없이 스프링 부트 프로젝트로 개발 가능

### ch02. 스프링의 핵심 기술 익히기
#### 01. 자바, 그리고 스프링, 스프링 부트
- 자바
    - 객체 지향 프로그래밍 언어
    - 스프링의 근간이 되는 언어
    - 스프링은 자바 뿐 아니라 코틀린, 그루비로도 사용될 수 있으나 거의 대부분이 자바로 만들어져 있음(이건 몰랐넹)
    - 자바는 jvm 만 설치되어 있다면 어디서든 수행 가능
    - 스프링 프레임워크는 굉장히 좋은 코드이기때문에 스프링 프레임워크 자체 코드를 보고 공부해도 꽤 좋음
- 스프링
    - 스프링 프레임워크는 어플리케이션을 만드는데 사용하는 오픈소스 프레임워크라고 보면 된다.
    - 상당히 다양한 라이브러리를 가지고 있음(db 접근, 웹 기반 라이브러리, 스프링 특화 기능 등)
    - 스프링도 15년 이상 되어서 꽤 오랜시간 개발된 프레임워크임
- 스프링 부트
    - 스프링 기반으로 자주 사용되는 설정을 손쉽게 개발할 수 있게 해주는 상위 프레임워크
    - 항상 사용하는 기능들은 비슷하기 때문에 그것들을 더 편하게 사용할 수 있도록 해줌
    - was 서버도 내장되어있고, 설정도 자동으로 해주지만 자기 마음대로 설정도 가능
    - was(톰캣)이 내장되어 있기 때문에 따로 was를 깔고 설정을 해줄 필요 자체가 없음

#### 02. 스프링의 core technology
- 스프링을 사용하다 보면 항상 비슷한 패턴으로 만들게 될 것
- 스프링 프레임워크 런타임.png 사진을 보면 어떤 기능들을 하는지 대충 알 수 있음
- 디자인 철학이 존재함
    - 한가지 기능에 대해서 한가지 모듈만 제공하는 것이 아니라서 다양한 모듈 사용 가능(예전것도 있고, 지금 것도 있음)
        - 너무 높은 자유도 때문에 혼란이 올 수 있음
    - 유연하게 계속 추가 개발을 하고 있는 프레임워크임(현재 진행형)
    - 이전 버전과 호환성이 좋음(옛날 버전으로 개발된 코드들 같은 경우에도 최신 기술을 추가하여 같이 사용 가능)
    - API 디자인을 섬세하게 노력하기 때문에 공부용으로 보기 꽤 좋은 코드임
    - 높은 코드 품질을 유지함
    - 단, 너무 자유롭기 때문에 종종 어려울 수 있음

#### 03. DI - Dependency Injection
- 스프링은 레고 바닥판이라고 생각하고, 그 위에 내 어플리케이션을 만든다고 생각하면된다.
- 레고판 위의 클래스는 스프링으로 만든 내 클래스고, 그 밖에는 자바 클래스라고 보면 된다.
- Bean이란?
    - 자바에서의 javaBean
        - 데이터를 저장하기 위한 구조체로 자바 빈 규약이라는 것을 따르는 구조체
        - private 프로퍼티와 getter/setter로만 데이터를 접근하는 방식
    - 스프링에서의 Bean
        - 스프링에서는 IoC 컨테이너에 의해 생성되고 관리되는 객체
        - 우리가 만든 클래스를 Spring IoC 컨테이너에 인스턴스로 생성하고 Spring Application Context에 의해 설정된 설정값을 바탕으로 수행
- 스프링 컨테이너
    - ApplicationContext 인터페이스를 통해 제공되는 스프링 컨테이너는 bean 객체의 생성 및 bean들의 조립 등을 담당
- Bean의 등록
    - 과거에는 xml로 설정을 관리해서 등록했음
    - 현재는 annotaion 기반으로 bean 등록
        - @Bean, @Controller, @Service
- Bean LifeCycle callback
    - 특정 이벤트가 발생했을 때 호출되는 메서드를 callback이라고 함
    - Bean을 생성하고, 초기화하고 파괴하는 등의 특정 시점에서 호출되는 메서드를 lifecycle callback이라고 부름
    - 주로 @PostConstruct(빈 생성 시점에 호출), @PreDestroy(빈 파괴 이전에 마무리가 필요한 경우 호출)

#### 04. AOP
- AOP는 관점 지향 프로그래밍으로 Aspect Oriented Programming 의 약자임
- 공통적인 부분을 스프링이 받아서 처리해주는 것
    - 로깅, 트랜잭션, 인증 등의 작업을 만들 때 AOP를 사용 하면 깔끔함
- OOP로 처리하기 다소 까다로운 부분을 AOP방식을 도입하면 쉽게 공통 기능을 추가/수정/삭제 할 수 있음
- AOP를 쓰면 코드의 분석이 어려워 실무에서 많이 쓰지는 않지만 꼭 필요한 부분엔 사용함
- AOP의 기본 개념
    - Aspect 는 여러 클래스나 기능에서 공통적으로 사용할 때 모듈화함, AOP 중에서 가장 많이 활용하는 부분은 @Transactional 기능
    - Advice 는 AOP에서 실제로 적용하는 기능
    - Join point 는 Aspect가 실행될 수 있는 부분들
    - Pointcut 은 Join point 중에서 해당 Aspect를 실제로 적용할 대상을 뽑는 조건식
    - Target Object는 Advice가 실제로 적용될 대상 오브젝트
    - AOP Proxy는 대상 오브젝트에 aspect를 적용하는 경우 advice를 덧붙이기 위해 하는 작업
    - Weaving은 Advice를 비즈니스 로직 코드에 삽입하는 것
- AspectJ는 AOP를 제대로 사용하기 위해 꼭 필요한 라이브러리임
- AspectJ는 스프링부트에 기본적으로 포함되어있음
- 포인트컷은 특정 메서드 대상이나, 특정 클래스에 대한 포인트컷, 두개의 조건을 결합한 포인트 컷을 만들 수 있음
- @Before("메소드"), @AfterReturning("메소드"), @Around("메소드")를 통해서 메소드를 호출하기 전, 후, 둘다 를 지정해줄 수 있음
- critical section에 접근하고 나올때의 로직을 AOP로 만들어 줄 수 있음

#### 05. Validation, Data binding
- Validation
    - 유효성 검증으로 주로 사용자 또는 서버의 요청 내용에서 잘못된 내용이 있는지 확인하는 단계
    - 개발자가 주로 챙겨야하는 유효성 검증은 2가지 있음
        - 데이터 검증 : 필수 데이터 유무, 문자열 길이, 숫자형 데이터 범위, 형식 등 확인
        - 비즈니스 검증 : 서비스에 정책에 따라 데이터 검증(ex. 배달앱의 경우 배달의 주문건이 결제 완료된 상태인가), 경우에 따라 외부 api를 호출하거나 db 데이터 조회 후 검증 필요
- Spring에서의 Validation
    - 스프링은 웹 레이어에 종속적이지 않은 방법으로 유효성 검증을 하려고 의도함
    - java bean validation
        - java bean 기반으로 간편하게 개별 데이터 검증
        - 요즘 가장 많이 활용하는 방법으로 JavaBean 내에 어노테이션으로 검증 방법을 명시
    - Spring validator 인터페이스 구현을 통한 검증
        - supports는 validator 가 동작할 조건 정의
        - validate는 검증
        - java bean validation을 더 많이 써서 잘 사용 안함
- validation 수행 시 주의사항 및 패턴
    - validation을 너무 여러군데에서 하면 테스트, 유지보수성 떨어짐
    - 여러군데에서 하면 할때마다 다른 검증 방법으로 이상하게 수행 될 수 있음
    - validation 실패하면 exception을 날리는것이 좋음
- 실무에서의 유효성 검증
    - 요청 dto에서 1차 검증
    - 실 서비스 로직 초반에 비즈니스 검증 로직 수행
    - 실무에서 spring validator를 사용하였을 때의 장단점
        - javabean validator보다 복잡한 검증 가능
        - 코드 찾기가 어려움
        - 완전히 데이터만 검증하는 것이 아니기 때문에 일부 비즈니스 검증이 들어갈 수 있음
    - 해당 팀에서 사용하는 검증 패턴을 따르면 됨
- Data Binding
    - 사용자나 외부 서버에서 요청 데이터가 들어오면 특정 도메인 객체에 저장해서 우리 프로그램에 request에 담아주는 것
- Convert<s,t> interface
    - s타입을 받아서 t타입으로 변환해주는 인터페이스

    ```
        public interface Convert<S, T>{
            T convert(S source);
        }
    ```
    - 와 같은 형태
    - json 타입으로 들어온 값을 우리가 원하는 객체로 변환해줄 수 있음
- 컨버터가 spring bean으로 등록이 되어있으면 컨버터를 통해서 body나 header를 변환해줄 수 있음
- 대외계 오픈소스 쓸 때 json으로 들어올 때 이름을 맞춰주는데 이것 때문일 것 같음
- Formatter
    - 특정 객체와 string 간의 변환을 담당
    - date와 string 같은 변환을 할 때 사용
    - 대부분의 객체에 대해서 json으로 변경해서 보내줄 때 formatter를 사용

#### 06. Resourse
- Spring Resource는 java.net.URL의 한계(classpth 내부 접근이나 상대경로 등)을 넘어서기 위해서 스프링에서 추가로 구현한 것
- 파일 관련해서 주로 사용하는 것
- 지원해주는 함수는 https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/resources.html 참고
- Resource 구현체 목록(스프링 내부 리소스 구현체 중 대표적인 것들)
    - UrlResource : java.net.URL을 래핑한 버전으로 기본적으로 HTTP로 원격 접속
    - ClassPathResource : classpath를 통해 하위 의 리소스 접근 시 사용
    - FileSystemResource : 파일을 다루기 위한 리소스 구현체
    - SevletContextResource, InputStreamResource, ByteArrayResource : 이외의 다양한 구현체들
- Spring ResourceLoader
    - 스프링 프로젝트 내 resource에 접근할 때 사용
    - 기본적으로 applicationContext(스프링의 가장 핵심적인 기능이 모여있는 곳)에서 구현되어있음
    - 대부분의 파일들은 자동으로 로딩되도록 되어있으나, 추가로 필요한 파일이 있을 때에 이 부분 사용
    ```
        ApplicationContext ctx;
        Resource myTemplate = ctx.getResource("classpath:some/resource/path/myTemplate.txt");
    ```
- ResourcePatternResolver
    - 스프링 ApplicationContext에서 ResourceLoader를 불러올 때 사용하는 인터페이스
    - 위치 지정자 패턴(classpath, file, http)에 따라 리소스 로더 구현체를 선택
- 어플리케이션 컨텍스트, 리소스 패스
    - 예전에는 xml로 설정을 지정해줬는데 이때 보통 사용했었음

#### 07. Spring Expression Language(SpEL)
- 표현언어는 짧고 간단한 문법을 통해서 필요한 데이터나 설정값을 얻어올 수 있게 해주는 특별한 형태의 표현식에 가까운 간편한 언어
- 주로 @Value("${config.value}")와 같은 방법으로 사용
- SpelParser는 "" 안에 들어있는 문자열을 평가해서 결과값 생성
- 보통은 값이 종종 바뀔 때 사용
```
@Value("#{ 1+1 }")
int two;
```
- 로 하면 two에는 2가 들어감
- hostname 같은 경우 테스트와 운영을 다르게 해야하는데 이럴 때 많이 사용
```
@Value("${server.hostname }")
String hostName;
```

#### 08.Null-safety
- 자바는 null에대한 체크가 자동으로 되지 않기 때문에 수동으로 필요함
- 매번 해야하기 때문에 번거로움
- Null Safety를 넣으면 ide에서 위치에 경고를 표시해줌
- @NonNull
    - 해당 값이 null이 아님을 나타내는 어노테이션
    - org.springframework.lang.NonNull 사용
    - 파라미터 선언 앞에 @NonNull을 써주면 된다
    - 메소드에도 @NonNull을 붙여주면 return값이 null이 오면 경고를 내줌
- Nullable
    - 해당 데이터가 null일 수 있음을 나타내는 것
    - 이걸 달아주면 해당 어노테이션이 붙은 값을 사용하는 경우 null check를 항상 수행하도록 경고뜸
    - 스프링에서 제공해주는 것 이외에 jetbrain이나 lombok에서 제공해주는 null 관련 어노테이션도 있음


### Ch03. 예제를 만들며 이해하는 스프링 웹 어플리케이션 핵심 기술
#### 01. 만들어볼 에제에 대한 설명
- 프로젝트 명 : 개발자 키우기 프로젝트
- 사람이 http로 요청을 날리면 데이터 바인딩해주고 검증 해주고 db와 transaction을 주고 받고 (예외처리하고) http 응답
- 주요기능
    - 개발자 생성하기 : post 메소드를 이용하여 개발자 생성(validation에 대해서 배우게 될 것)
    - 개발자 목록과 특정 개발자 상세 내용 확인 : get 메소드를 활용하여 개발자 정보를 확인(DTO의 개념과 역할에 대해서 배우게 될 것)
    - 개발자 정보 수정 : PUT 메소드를 이용하여 수정
    - 개발자 삭제 : DELETE 메서드를 활용하여 개발자의 정보를 삭제(분리보관) (트랜잭션에 대해서 배울 것)

#### 02. 롬복 설명
- 롬복은 자바 스프링에서 반복적으로 사용하는 코드들을 간편하게 자동으로 쓸 수 있게 해주는 것
- build.gradle에 추가해서 사용하면 됨(dependencies 내에 선언)
```
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
```
- getter 와 setter도 자동으로 생성해줄 수 있지만 변수명이 바뀌면 하나하나 수정해야하는 문제가 있는데 이것도 롬복으로 해결 가능(단 변수명에 shift + f6 누르면 사용하는 곳 한번에 변경도 가능)
- dto를 테스트 할 때에는 ctrl+shift+t를 누르면 테스트 코드 생성 가능
- 이 장에서 프로젝트에 생성된 것은 dmaker 폴더에 넣을 것
- @Builder를 사용하면 atomic 하게 코드를 짤 수 있음
- @Slf4j를 사용하면 로그를 조금 더 손쉽게 찍을 수 있음
- @Setter는 setter를 선언
- @Getter는 getter를 선언
- @ToString는 System.out.println에 해당 클래스의 인스턴스를 넣으면 string 형식으로 보여줌
- @NoArgsConstructor는 argument 가 없는 생성자 생성
- @AllArgsConstructor 는 모든 argument가 들어간 생성자 생성
- @RequiredArgsConstructor는 일부 argument 가 들어간 생성자 생성
- @Data는 이거 하나면 위의 6줄 다 필요없음, 양날의 검이라 실제에서는 잘 안씀
- 롬복에는 이외에도 다양한 기능이 많기 때문에 찾아서 사용하면 된다.

#### 03. http 스팩에 대한 설명
- http는 하이퍼 텍스트를 전송하는데 활용하는 프로토콜
- 요청과 응답의 정의에 대해서만 간략 설명
- http request 메시지 스펙
    - 첫째줄 : 요청라인(http 메서드(get,put,post 등))
    - 둘째줄 ~ 줄바꿈 전까지 : header
    - 그 이후 : request body
```
POST /create-developer HTTP/1.1   //요청라인
Content-Type: application/json
ACCEPT: application/json   //header

{
    json 내용
}//request body
```
- http response 메시지 스펙
    - 첫째줄 : 상태라인(200,500, 404 등)
    - 두번째줄부터 줄바꿈 나올때까지 : header
    - 그 이후 : request body
```
HTTP/1.1 200 OK
Content-Type: application/json
... //헤더

{
    json 내용
}  //바디
```
- http 스펙은 백엔드 개발자로써 알아두는 것이 좋음
- http 완벽 가이드 책 좋다고 함

#### 04. 아주 단순한 구조(1Layer)의 어플리케이션
- spring initializer 에서 우측에 디펜던시를 골라서 추가할 수 있음(롬복, 스프링 웹, h2 db 같은 것)
- package는 controller, dto, entity, service 이런식으로 나눠서 만들어놓고 구분해서 사용하는 것이 좋음
- 프로젝트는 project/dmaker 폴더
- @RestController는 bean 에 등록하는데 타입은 restcontroller인 것 (컨트롤러인데 리스폰스 바디를 붙여주는 것)
- @GetMapping("/developers") 이런식으로 선언해두면 GET /developers HTTP/1.1 이런식의 요청이 오면 그 함수를 수행하는 것

#### 05. H2 DB 설명, 간단한 DB 저장 기능 구현
- H2 DB는 주로 메모리 DB로 많이 사용하는 DB로 디펜던시에 추가하여 사용
- 메모리에 남는 DB이기 때문에 어플리케이션이 죽으면 안의 내용이 다 지워짐
- 간단한 테스트용으로 주로 사용
- h2 디비의 내용을 보려면 application.properties 파일을 application.yml 파일로 리팩로링 해주고 아래내용 추가
```
spring:
  h2:
    console:
      enabled: true
```
- 그럼 콘솔창에 jdbc:h2:mem:93d70239-3e7b-4c14-b3de-1c51ab014104 이런식으로 나오는데 http://localhost:8080/h2-console 을 통해서 콘솔 접근
- @Entity를 넣어서 엔티티를 만들어줌
- entity를 통해서 데이터베이스 틀을 만들고 repository를 생성해서 저장할 수 있는 repository 생성해서 사용
- Service 에서 해당 entity를 사용하여 서비스를 만들고 controller에서 해당 서비스를 수행할 수 있도록 GET, POST 등 을 만들어서 사용하면됨
- 결론 : entity(틀), repository(저장소), service(동작 함수), controller(호출 방법) 이렇게 구현 필요

#### 06. 트랜잭션의 개념
- 트랜잭션은 여러 과정을 하나로 묶을 때 사용함(실패시 모두 취소됨)
- 트랜잭션의 기본적인 덕목은 acid 로 압출할 수 있음
- ACID
    - Atomic : 원소성(하나의 함수가 하나처럼 동작하는 것)
    - Consistency : 일관성
    - Isolation : 고립성(db의 고립성이 낮으면 아무나 접속할 수 있어서 신뢰성이 떨어질 수 있음, 반대면 한 트랜잭션만 동일한 시간에 수행할 수 있기에 문제) 적절히 고려해야함
    - Durability : 지속성(모든 이력을 남김)