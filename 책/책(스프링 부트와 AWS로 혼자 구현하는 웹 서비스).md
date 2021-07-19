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