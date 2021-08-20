# 한 번에 끝내는 Spring 완.전.판 초격차 패키지 Online

## [무료제공] IntelliJ 가이드

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
- 