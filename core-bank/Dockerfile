FROM adoptopenjdk/openjdk11:x86_64-alpine-jdk-11.0.4_11 as packager

EXPOSE 8080

RUN mkdir /app
COPY target/*.jar /app/core-banking.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/core-banking.jar"]

HEALTHCHECK --interval=1m --timeout=3s CMD wget -q -T 3 -s http://localhost:8080/account/all/ || exit 1
