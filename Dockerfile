# Java 런타임이 포함된 기본 이미지 사용
FROM openjdk:17-jdk-slim

# /tmp 경로에 볼륨 추가
VOLUME /tmp

# 외부에서 이 컨테이너로 접근할 수 있도록 포트 8080 열기
EXPOSE 8080

# 애플리케이션의 jar 파일을 컨테이너에 복사
COPY full-Stack-Restapi/target/*.jar app.jar

# jar 파일 실행
ENTRYPOINT ["java","-jar","app.jar"]
