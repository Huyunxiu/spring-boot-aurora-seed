FROM openjdk:8-jdk-alpine

ENV SPRING_PROFILES_ACTIVE=pre

MAINTAINER huyunxiu01@gmail.com

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /app

WORKDIR /app

EXPOSE 8080

COPY ./target/*.jar /app/app.jar

CMD ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
