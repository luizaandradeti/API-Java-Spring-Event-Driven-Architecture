FROM maven:3.9.9-eclipse-temurin-17 AS builder

WORKDIR /application

COPY pom.xml .

COPY src ./src

RUN mvn clean package

FROM openjdk:17-jdk AS runner

WORKDIR /application

COPY --from=builder ./application/target/*.jar ./application.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "application.jar"]