FROM openjdk:8-jdk-alpine
MAINTAINER "pdk"
VOLUME /tmp
ADD "/build/libs/yuesao-0.0.1-SNAPSHOT.jar" "yuesao-0.0.1-SNAPSHOT.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","/yuesao-0.0.1-SNAPSHOT.jar"]
