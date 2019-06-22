FROM maven:3.5-jdk-8-alpine
MAINTAINER huyunxiu01@gmail.com

ENV SPRING_PROFILES_ACTIVE=pre
ENV TIME_ZONE=Asia/Shanghai
ENV MY_HOME=/app

# 创建主目录，更改当前时区为上海
RUN \
  mkdir -p ${MY_HOME} \
  && echo "${TIME_ZONE}" > /etc/timezone \
  && ln -sf /usr/share/zoneinfo/${TIME_ZONE} /etc/localtime

# 为了更好的利用docker缓存，先根据pom安装依赖
COPY pom.xml ${MY_HOME}
RUN cd ${MY_HOME} && mvn verify clean --fail-never

# 构建打包
COPY . ${MY_HOME}
WORKDIR ${MY_HOME}
RUN mvn package -Dmaven.test.skip=true
RUN cp ${MY_HOME}/target/*.jar ${MY_HOME}/app.jar

EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
