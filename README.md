# 메모

- Controller 작동하는 원리 찾아볼 것

- JSP란?
    HTML 코트에 Java코드를 삽입해서 동적인 웹페이지를 생성
    (장고에서 탬플릿언어같은 느낌인듯)
    JSP컨테이너에서 JSP 파일을 읽어와서 Servlet(Java코드 내 HTML 코드)으로 변환 -> 이렇게 변환된 Servlet은 class파일로 컴파일 -> 실행을 통해 JSP 컨테이너로 전달 -> JSP 컨테이너에서 클라이언트로 HTML페이지 전달

    근데 스프링부트에서는 템플릿엔진을 쓰라고 권장한단다 왜그러지?
    +) 공식문서 보니까 JAR을 지원하지 않아서 WAR로 써야한단다.
    서블릿엔진중에 JSP 지원안하는애(언더토우)도 있고.. 
    그리고 JSP는 MVC중 뷰만 담당하게 되어서 비즈니스로직을 넣으면 디버깅이나 유지보수가 힘들어진단다.

- JAR? WAR?
    JAR은 자바어플리케이션이 동작할 수 있게끔 프로젝트를 압축히켜놓은 파일
    원하는 구조로 구성할 수 있으며 JRE만 있으면 실행가능

    WAR은 JAR의 옵션파일.
    servlet이나 JSP컨테이너에 배치할 수 잇는 웹어플리케이션 압축파일 포맷
    servlet 관련 파일들로 패키징되어있음, 사전정의된 구조로만 사용하며 웹서버가 따로 필요함. 

- 템플릿엔진 
    thymeleaf 타임리프라니.. 허브덕훈가? 이름이 귀엽... 여담이긴한데 컴퓨터관련 프레임워크나 언어, 라이브러리들중 은근 이름 귀여운거 많다. 쿠키나 버그같은것도 꽤 귀엽고 얼마전에 본 nipple.js는 갠적으로 좀 충격이였지만..(가상조이스틱라이브러리인거 보고 기분이 괜히 더 이상해졌음...)

    아무튼 사용할 서버사이드 자바 템플릿 엔진은 타임리프다.
    JSP와 달리 Servlet 코드로 변환되지 않고, HTML 파일내에 태그에 필요한 정보를 넣고, 이를 파싱+분석한 후 데이터를 치환하여 웹페이지를 생성한다. 
    따라서 비즈니스 로직이랑 분리되어서 화면자체에 집중할 수 있다는 점과
    웹서버를 실행시키지않아도 오프라인에서 수정할 수 있다는 장점이 있다.
    대부분의 장점을 보았을대 퍼블리셔나 디자이너,클라단과 함께 작업하기 좋겠다는 생각이 든다.
    단점이라고 한다면 JSP나 다른 템플릿 엔진대비 속도가 느린듯
    아 근데 대부분 이거쓰던데 왜 다른 템플릿엔진이 아닌 타임리프를 쓰는거지?

- dependency 변경후 
프로젝트 디렉토리 이동 후 
maven clean
maven install 
maven package

- jsp 설정이 안먹어서 빡쳤었는데
대쉬보드에서 다시 디버깅+런 하던가 아예 프젝을 껏다 켜면 됨...ㅎ 야호^0^

- 모델
컨트롤러에서 모델값 조작 -> jsp로 넘겨서 화면출력 까지는 이해가 되는데
모델이 당최 어케  돌아가는건지 이해가 안된다. 
파라미터값 넣으면 데이터 만들어지긴하던데.. 모델 선언도 안했는데 뭔원리로 만들어지는거지?
어차피 jpa쓰긴할건데./..흠 -> 

- JPA 에러로그
could not open jpa entitymanager for transaction; nested exception is org.hibernate.exception.jdbcconnectionexception: unable to acquire jdbc connection
-> 참고자료: https://woowabros.github.io/experience/2020/02/06/hikaricp-avoid-dead-lock.html

org.springframework.beans.factory.beancreationexception: error creating bean with name 'entitymanagerfactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/hibernatejpaconfiguration.class]: invocation of init method failed; nested exception is org.hibernate.service.spi.serviceexception: unable to create requested service [org.hibernate.engine.jdbc.env.spi.jdbcenvironment]
-> application.properties쪽 설정오류로 인한 에러


-maven vs gradle
난 첫시작환경을 maven으로 했는데 튜토리얼을 진행하다보니 gradle이 더 많더라
어떤 차이점이 있는가 봤더니 maven은 ant의 불편함을 해소한 빌드스크립트 및 의존성관리툴? 이었고,
gradle은 maven과 ant의 장점만을 쏙 뽑아서 만든 빌드도구ㅇㅇ
xml을 사용하면서 개인적으로 가독성이 나쁘단 생각을 했었는데 gradle에서는 이런 가독성을 해결하고
의존관계가 복잡한 프로젝트를 설정할떄 좀 더 편리하게 했다고 한다. 또한 빌드 속도가 메이븐부도 100배는 빠르다니...(핫데이터 형식으로 빌드정보를 관리해서 좀더 빠르게 접근+반복작업 감소 / 변경된
클래스만 다시 컴파일한다고 함. 라이브러리 인터페이스가 변경되지 않으면 Gradle내의 스마트 경로 분석기가 재컴파일을 막는게 원리.)
 이제부터 할 spring 게시판 플젝은 Gradle을 사용해서 할 예정ㅎㅅㅎ

