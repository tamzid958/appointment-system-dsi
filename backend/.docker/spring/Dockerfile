# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS appointment_system_builder
WORKDIR /app/backend

COPY .mvn .mvn
COPY mvnw mvnw.cmd pom.xml ./
COPY src ./src

CMD ["mvn", "clean", "-DskipTests"]
CMD ["mvn", "clean", "package", "-DskipTests"]
CMD ["mvn", "clean", "install", "-DskipTests"]
CMD ["mvn", "spring-boot:run"]

# DevTools dependency
RUN mvn dependency:go-offline -Dartifact=com.dsi:appointment-system-dsi:0.0.1-SNAPSHOT

## Stage 2: Create a minimal JRE image
#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#COPY --from=appointment_system_builder /app/target/appointment-system-dsi.war appointment-system-dsi.war
#
#EXPOSE 8080
#
## Specify the default command to run on startup
#CMD ["java", "-jar", "appointment-system-dsi.war"]