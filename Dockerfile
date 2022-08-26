FROM adoptopenjdk/openjdk11

#컨테이너 안에서 사용할 변수 세팅
ARG JAR_FILE=build/libs/*.jar

#위에서 세팅한 변수의 내용을 컨테이너의 app.jar로 복사한다.
COPY ${JAR_FILE} app.jar

#컨테이너가 시작 되면 스크립트 실행
ENTRYPOINT ["java", "-jar", "/app.jar"]

#도커 이미지 만들기
## 도커 이미지는 반드시 소문자만 사용 가능
## docker build -t [image_name] .
## docker build -t kyj/web-socket .