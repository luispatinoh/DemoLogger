# Java 11
FROM adoptopenjdk/openjdk11:alpine-jre

# DemoLogger-0.0.1
ARG JAR_FILE=target/DemoLogger-0.0.1.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]