FROM maven:3.6.1-jdk-11-slim AS builder
COPY . /src/
WORKDIR /src/
RUN mvn clean package -Dmaven.test.skip=true

FROM openjdk:8-jre-alpine
COPY --from=builder /src/target/wdelivery-0.0.1-SNAPSHOT.jar /
ENTRYPOINT java -jar wdelivery-0.0.1-SNAPSHOT.jar
