# 스프링 부트와 AWS로 혼자 구현하는 웹 서비스


## 00.
- 스프링 부트는 어렵고 개발이 복잡하고 거추장스럽다고 생각하지만 스프링 부트가 권장하는 방식을 사용하면 서버에 톰캣같은 WAS 서버 설치 필요없고 오로지 JAR로만 서비스 운영 가능
- 네카라 등 우리나라 최고의 IT 기업에서 자바와 스프링 프레임워크 사용
- 좀 더 깊이 있는 책 : 토비의 스프링, 김영한의 JPA 책
- 예제 코드 다운로드 주소 : http://bit.ly/fr-springboot


## 01. 인텔리제이로 스프링 부트 시작하기
- 스프링 부트로 웹 서비스 만들기 위한 개발 툴 : 인텔리제이
### 1.1 인텔리제이 소개
- 자바 개발 시 이클립스를 많이 사용하나 인텔리제이가 갖는 강점이 있어서 스프링 부트 개발 시 인텔리제이 사용
- 인텔리제이 커뮤니티(무료버전)을 사용해도 스프링 부트 관련 기능은 거의 지원하기 때문에 개발하는데 문제 없음
### 1.2 인텔리제이 설치하기
- 인텔리제이를 직접 받지않고, 젯브레인의 모든 제품을 관리해 주는 데스크톱 앱인 젯브레인 툴박스를 이용하여 버전관리와 jvm 옵션 등 조정 가능
- https://www.jetbrains.com/toolbox/app/ 에서 설치 가능
- (나는 별도로 인텔리제이를 다운받아서 사용하고 있었는데 다른 어플도 사용한다면 훨씬 편할 것 같음)
- 툴박스에서 여러 도구를 설치할수도 있음
- 설치뿐만 아니라 각 툴의 다양한 설정을 조정 가능
- 힙설정은 메모리가 4GB일 때를 기본으로 설정되어있기 때문에 메모리가 더 크다면 크게 설정해서 사용 가능(내 컴퓨터는 16GB니까 2048 ~ 4096)
### 1.3 인텔리제이 커뮤니티에서 프로젝트 생성하기
- 인텔리제이에는 이클립스의 워크스페이스 개념이 없고 프로젝트와 모듈의 개념만 있음
- 따라서 모든 프로젝트를 한 번에 불러올 수 없고 하나의 프로젝트만 열림
- 툴박스에서 인텔리제이 클릭 시 실행
- 처음 설치 시, 개인의 기호에 맞게 설정 진행
- 새 프로젝트 생성 
  - New - Project - Gradle - Java - next - GroupId, ArtifactId 등록(이 때 AritifactId는 프로젝트의 이름이 됨) - gradle 기반의 자바 프로젝트 생성 완료
### 1.4 그레이들 프로젝트를 스프링 부트 프로젝트로 변경하기
- build.gradle에는 기본적인 자바 개발 설정이 되어있음
- 스프링 부트에 필요한 설정을 추가해줘야함(보통은 스프링 이니셜라이저(https://start.spring.io/)를 통해서 진행)
- 아래는 스프링 부트 사용 시 필요한 build.gradle 코드
```
    buildscript{ //플러그인의 의존성 관리
        ext { //ext 는 전역 변수 설정하겠다
            springBootVersion = '2.1.7.RELEASE' //스프링 부트 플러그인의 버전 설정
        }
        repositories { //라이브러리를 어떤 원격 저장소에서 받을 것인지를 결정
            mavenCentral() // 예전부터 많이 사용하지만 본인이 만든 라이브러리를 업로드하는데 많은 과정과 설정 필요
            jcenter() //라이브러리 업로드가 쉬우며 자동으로 mavenCentral에 업로드 되도록 설정 가능
        }
        dependencies {//프로젝트 개발에 필요한 의존성을 설정
            classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        }
    }
    // --------- 플러그인 의존성 설정 ----------------- //
    apply plugin: 'java'
    apply plugin: 'eclipse'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'
    //-----------------------------------------------//
    group 'org.dolmac'
    version '1.0-SNAPSHOT'
    sourceCompatibility = 1.8

    repositories {
        mavenCentral()
    }
    // --------------프로젝트 개발에 필요한 의존성들 선언하는 곳 --------------------- //
    dependencies {
        compile('org.springframework.boot:spring-boot-starter-web')
        testCompile('org.springframework.boot:spring-boot-starter-test')
    }
    // ------------------------------------------------------------------------ //
```
- 위의 설정이 모두 완료된 후 반영하라는 알람이 뜨면 확인을 눌러서 반영
- 반영이 완료되면 우측이 gradle 탭에서 반영이 잘 되었는지 확인
### 1.5 인텔리제이에서 깃과 깃허브 사용하기
- 최근에 SVN에서 깃으로 완전히 전환되어 가는 추세(요즘은 SVN 사용하는 곳을 찾아보기 힘듬)
- 깃의 원격 저장소 역할을 하는 것이 깃허브와 깃랩이 있는데 대중적으로 깃허브 사용(회사에서 깃랩 사용할 기회가 있을 것임(형상관리))
- 인텔리제이에서 Action창 실행(ctrl + shift + a) -> share project on github 검색 -> 깃 로그인 -> 레포지토리 설정 -> .idea를 제외한 파일만 커밋되도록 설정(.idea는 인텔리제이 프로젝트 생성 시 자동 생성)
- git에서 커밋 대상에서 제외 처리할때는 .gitignore을 사용하는데 인텔리제이에서는 이 기능을 .ignore 플러그인에서 지원
  - action창 -> plugins -> ignore 검색 후 설치 -> 재시작 -> 프로젝트 우클릭 -> new -> .ignore file -> .gitignore file -> 생성
  - ignore 할 파일들 지정 (자동 생성 프로그램을 막으려면 .gradle 이랑 .idea 쓰면 된다)
  - 깃 커밋창 실행 (ctrl + k) -> 커밋 -> 깃 푸쉬 실행(ctrl + shift + k) -> push 버튼 클릭
- 개발 환경 구성 끝
- 해당 책에 대해 공부한 코드는 springboot 레포지토리에 올라갈 것


## 02. 스프링 부트에서 테스트 코드를 작성하자
- 견고한 서비스를 만들고 싶은 곳에선 TDD를 하거나 최소 테스트 코드를 작성함
- 최근에는 대부분의 회사가 테스트 코드에 관한 요구사항 존재
### 2.1 테스트 코드 소개
- TDD != 단위 테스트임
- TDD는 테스트가 주도하는 개발로 테스트 코드를 먼저 작성하는 것부터 시작함
- TDD = 항상 실패하는 테스트(RED) + 항상 성공하는 테스트(GREEN) + 리팩토링
- 단위테스트 = 순수한 테스트 코드 작성
- 테스트 코드의 장점
  - 빠른 피드백 : 중간의 작업 단계들을 실행할 필요 없음
  - 자동 검증 : 눈으로 검증하지 않아도 자동으로 검증해줌
  - 개발자가 만든 기능을 안전하게 보호
- 테스트 코드는 더이상 옵션이 아닌 100퍼센트 익혀야할 기술이자 습관임
- 가장 대중적인 테스트 프레임워크 : xUnit ( 여기서 x는 언어 ) ex> JUnit, CppUnit 등
- 우리는 자바를 개발할 것이므로 JUnit을 사용할 것
### 2.2 Hello Controller 테스트 코드 작성하기
- 일반적으로 패키지 명은 웹 사이트 주소의 역순으로 함
- 스프링 부트에서는 언제 어디서나 같은 환경에서 스프링부트를 배포할 수 있도록 내장 WAS를 권장함
  - 외장 WAS를 사용하면 WAS의 종류, 버전, 설정 등을 일치 시켜줘야함
```
//항상 스프링 부트 어플리케이션 최상단에 있어야 할 클래스 파일(여기서는 Application 클래스 파일)
package com.dolmac.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링 부트의 자동 설정을 해주며 항상 프로젝트의 최상단에 위치해야함
public class Application { // 앞으로 만들 클래스의 메인 클래스가 될 것
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); //내장 was를 통한 실행
    }
}

```
- 테스트 컨트롤러 파일
```
package com.dolmac.springboot.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 json을 반환하는 컨트롤러로 변환해줌
public class HelloController {
    @GetMapping("/hello") //get method 요청을 받을 수 있는 api
    public String hello(){
        return "hello";
    }// 이제 이 프로젝트는 /hello로 요청이 오면 hello를 반환해줄 것

}

```
- 보통 테스트 테스트 클래스는 대상 클래스 이름에 Test를 붙임
- 테스트 코드를 수행했을 때 tasks passed 가 총 갯수와 같다면 모든 테스트를 통과했음을 의미
```
// 테스트 코드 예제
package com.dolmac.springboot;


import com.dolmac.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class) // 실행자를 스프링 부트로 바꾸겠다.
@WebMvcTest(controllers = HelloController.class) //스프링 테스트 어노테이션 선언
public class HelloControllerTest {
    @Autowired //스프링이 관리하는 빈(bean)을 주입받음
    private MockMvc mvc;//웹 api를 테스트할 때 사용

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))//MockMvc를 통해 /hello를 get요청
                .andExpect(status().isOk())//mvc.perform의 결과를 검증해서 상태가 200인가
                .andExpect(content().string(hello));//리턴하는 값이 string type의 hello가 맞는지 검증
    }
}
//위에서 작성했던 HelloController를 테스트하기 위한 HelloControllerTest 파일
```
- 테스트 코드는 아까 작성했던 최상단 어플리케이션 파일에서 main문을 실행 후 localhost:8080/함수의 형태로 테스트 해볼 수 있음
### 롬복 소개 및 설치
- 롬복 : 자바 개발자들의 필수 라이브러리의 이름임
- Getter, Setter, 기본 생성자 등 자동으로 생성해줌
- 인텔리제이에서는 플러그인을 통해 쉽게 롬복 설정 가능
  - build.gradle의 dependencies 부분에 compile('org.projectlombok:lombok') 한줄 추가해주고 새로고침 해주면 된다.
  - action창에서 plugins - lombok 검색 후 설치 - 인텔리제이 재실행
  - setting - build - complier - annotaion processors 체크
- 롬복을 활용한 테스트 코드
```
// 테스트 컨트롤러 파일
package com.dolmac.springboot.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter//선언된 모든 필드의 get 메소드 생성
@RequiredArgsConstructor //선언된 모든 final 필드가 포함된 생성자를 생성
public class HelloResponseDto {

    private final String name;
    private final int amount;
}

```
- 테스트 코드
```
package com.dolmac.springboot.dto;

import com.dolmac.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //같은지 검증
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}

```
- 이 책을 공부할 때 gradle 4.10.2버전을 사용할 것(안그러면 에러난다.)
- 롬복 테스트를 위해서 만든 함수도 테스트할 수 있음
```
    //컨트롤러에 추가할 것
    @GetMapping("/hello/dto") //HelloResponseDto 를 get 해서 사용
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
```
- test용 java 파일에 추가할것
```
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "dolmac";
        int amount = 1000;
        mvc.perform(get("/hello/dto").param("name",name).param("amount",String.valueOf(amount)))//param 은 파라미터 지정(단 string만 가능해서 변환)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))//선언된 필드와 받아온 필드가 값이 같은지 비교
                .andExpect(jsonPath("$.amount",is(amount)));
    }
```


## 03. 스프링 부트에서 JPA로 데이터 베이스 다뤄보자
- 보통은 Spring + MyBatis 형태로 데이터 베이스 관련하여 사용하지만 요즘은 스프링부트 + JPA 형태를 표준으로 사용하는 기업들도 많아짐
### 3.1 JPA 소개
- 현대의 웹 애플리케이션에서는 RDB를 뺄 수 없음
- 객체를 관계형 데이터베이스에서 관리하는 것이 중요
- 관계형 데이터베이스가 웹 서비스의 중심이 되다보니 SQL이 가득해짐
- 관계형 데이터베이스와 객체지향프로그래밍 언어의 패러다임이 너무 다름
- JPA는 이러한 서로 다른 패러다임을 가진 관계형 데이터베이스와 객체지향 프로그래밍의 중간에서 패러다임 일치를 시켜주는 기술임
- JPA는 인테페이스로서 자바의 표준 명세서임
- 스프링에서는 Spring Data JPA라는 모듈을 사용하여 JPA 기술을 다룸
- Spring Data JPA 는 Hibernate를 통해서 JPA에 접근하는데 한단계 더 감싸둔 것은 이유가 있음
  - Hibernate 외에 다른 구현체가 대세가 된다면 쉽게 교체하기 위함
  - 관계형 데이터베이스 외에 다른 저장소로 쉽게 교체하기 위함
    - 정말 큰 데이터를 다뤄야해서 몽고DB로 바꿔야 하는 경우 등
- Spring Data 의 하위 프로젝트들은 기본적인 명령어가 같아서 바꾸기 편리하다는게 핵심적인 이유
- 실무에서 JPA를 잘 사용하지 못하는 이유는 배우기 어렵다는 것
  - 객체 지향 프로그래밍과 관계형 데이터베이스를 잘 알아야하기 때문에
- 하지만 잘 사용만하면 큰 보상이 있음
  - CRUD를 직접 짤 필요 없고
  - 부모-자식 관계 표현, 1:N관계 표현 등 객체지향 프로그래밍이 쉬움
- 속도 이슈가 있지 않을까라는 문제도 있지만 JPA에는 성능 이슈 해결책들이 있어서 괜찮다
- 앞으로 개발할 것 : 하나의 게시판 웹 어플리케이션
### 3.2 프로젝트에 Spring Data Jpa 적용하기
- build.gradle에 의존성 등록 필요
```
    compile('org.springframework.boot:spring-boot-starter-data-jpa') //스프링 부트용 Spring Data Jpa 추상화 라이브러리
    compile('com.h2database:h2') //인메모리 관계형 데이터베이스
```
- domain 패키지를 만들고 이 패키지는 xml에 쿼리를 담고, 클래스는 오직 쿼리 결과만 담던 일을 도메인 패키지에서 해결
- 보통은 필수 어노테이션(@로 시작하는 것)은 클래스에 가깝게 필수가 아닐수록 멀리 둔다
- DB테이블과 매칭될 클래스를 모통 Entity class라고 함
- 보통 이 Entity Class를 이용하여 데이터를 수정하지 직접 쿼리를 날리진 않음
- spring-boot 레포지토리에 개발된 프로그램의 Entity Class
```
package com.dolmac.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // getter 메소드를 사용하겠다
@NoArgsConstructor //기본 생성자 자동 생성
@Entity //테이블과 링크될 클래스일때 사용

public class Posts {
    @Id // 테이블의 pk를 나타낼 때 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto increment를 이용하여 id 생성
    private Long id;

    @Column(length = 500, nullable = false) //해당 클래스의 컬럼을 나타내며 굳이 선언하진 않아도 됨(문자열의 경우 varchar(255)가 기본 타입임)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private  String content;

    private String author;

    @Builder //빌더 패턴 클래스 생성
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

```
- 보통 서비스 초기에는 테이블 설계가 자주 바뀌는데 롬복의 어노테이션들이 변경을 최소화하도록 도와줌
- 자바빈 규약을 생각했을 때 getter/setter를 무작정 생성하는 경우가 있는데 이럴 경우 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 명확하기 구분하기 어려워 entity 클래스에는 setter를 만들지 않는다.
- 대신 목적과 의도를 나타낼 수 있는 메소드를 추가하여 값변경을 해야함(ex. 주문 취소)
- setter를 통해 값을 넣는게 아닌 주문취소라는 함수가 있으면 파라미터를 안넣고 주문이 바로 취소될 수 있도록
- 빌더 패턴을 이용하여 개발하면 좋음
```
    example.bulider()
        .a(a)
        .b(b)
        .build();
```
- Posts 클래스를 생성했으니 database에 접근할 jpa레포지토리 필요
- 보통 ibatis나 mybatis에서 dao라고 부르는 것을 jpa에선 레포지토리라고 함
- 인터페이스를 생성하고 JpaRepository<Entity class명, pk 타입> 이런식으로 상속만 하면 기본 crud는 자동으로 생성됨
- 단 entity class 와 entity repository는 항상 같은 폴더에 있어야함
### 3.3 Spring Data JPA 테스트 코드 작성하기
- 기존에 TEST 코드를 작성하듯 test 경로에 작성하면 됨
- 테스트를 위한 코드(PostsRepositoryTest.java)
```
package com.dolmac.springboot.domain.posts;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @After //단위 테스트가 끝날때마다 수행할 동작
    public void cleanup(){
        postRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postRepository.save(Posts.builder().title(title).content(content).author("dolmac@naver.com").build());
        //테이블에 insert나 update 수행
        //when
        List<Posts> postsList = postRepository.findAll();//테이블에서 모든 데이터 조회

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

```
- 위의 코드는 테스트로 데이터를 저장하고, 정상적으로 되었는가 체크하고, 삭제하는 순으로 동작한다.
- @SpringBootTest를 사용할 경우 H2 데이터베이스가 자동으로 실행
- jpa를 통한 쿼리의 로그를 보고싶다면 resourcs 밑에 application.properties를 만들고 spring.jpa.show_sql=true로 설정해주면 된다.
- 로그에 mysql 형식으로 로그를 찍고싶다면 아래와 같이 application.properties에 추가해주자
```
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
```
### 3.4 등록/수정/조회 API 만들기
- API를 만들기 위해서는 총 3개의 클래스가 필요
  - Request 데이터를 받을 Dto
  - API요청을 받을 Controller
  - 트랜젝션, 도메인 기능 간의 순서를 보장하는 Service(단, 서비스에서는 로직을 처리하는 것이 아닌 순서 보장만 해준다.)
- 등록/수정/조회 동작을 하는 프로그램은 springboot 레포 참조