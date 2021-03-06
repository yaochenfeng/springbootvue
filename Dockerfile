FROM node:alpine as appfront
LABEL maintainer="282696845@qq.com"
WORKDIR /usr/src/app
COPY ./appfront .
RUN npm install && npm run build

FROM  maven:alpine as BUILD
LABEL maintainer="282696845@qq.com"
WORKDIR /usr/src/app
COPY . .
COPY --from=appfront /usr/src/app/dist ./src/main/resources/static
RUN mvn -f /usr/src/app/pom.xml clean package -P prod

FROM java:8-jre-alpine
LABEL maintainer="282696845@qq.com"
#add timezone and default it to Shanghai
RUN echo http://mirrors.aliyun.com/alpine/v3.6/main > /etc/apk/repositories;\
    apk --update add --no-cache tzdata curl
ENV TZ=Asia/Shanghai \
    JAVA_OPTS="" \
    SPRING_PROFILES_ACTIVE="prod" \
    APP_PORT=8080 \
    SPRING_APPLICATION_JSON='{"server.port":$APP_PORT}'
VOLUME /tmp
COPY --from=BUILD /usr/src/app/target/*.jar app.jar
EXPOSE $APP_PORT

ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar

HEALTHCHECK --interval=10s CMD curl -f http://localhost:$APP_PORT/_sys/health_docker