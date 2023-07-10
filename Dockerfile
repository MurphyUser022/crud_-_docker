FROM openjdk:17-jdk

WORKDIR /app

COPY .mvn/ .mvn
EXPOSE 8080
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve

COPY src ./src

CMD ["./mvnw", "spring-boot:run"]


#
#
#
#FROM openjdk:17-alpine
#
#RUN addgroup -S spring && adduser -S spring -G spring
#
#USER spring:spring
#
#ARG JAR_FILE=target/*.jar
#
#COPY ${JAR_FILE} app.jar
#
#ENTRYPOINT [ "java" , "-jar" , "/app.jar" ]