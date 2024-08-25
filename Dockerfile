# JDK17 이미지 사용
FROM openjdk:17-jdk-alpine

VOLUME /tmp

# JAR_FILE 변수에 값을 저장
ARG JAR_FILE=./build/libs/movetomove-0.0.1-SNAPSHOT.jar

# 변수에 저장된 것을 컨테이너 실행시 이름을 mom.jar파일로 변경하여 컨테이너에 저장
COPY ${JAR_FILE} mom.jar

# 빌드된 이미지가 run될 때 실행할 명령어
ENTRYPOINT ["java","-jar","mom.jar"]
