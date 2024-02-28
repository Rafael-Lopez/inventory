#
# Build stage
#
FROM maven:3.9.6-amazoncorretto-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM amazoncorretto:17.0.10
ENV DB_URL=
ENV DB_USERNAME=
ENV DB_PASSWORD=
COPY --from=build /home/app/target/inventory-0.0.1-SNAPSHOT.jar /usr/local/lib/inventory.jar
EXPOSE 8080
ENTRYPOINT java -Dspring.datasource.url=$DB_URL -Dspring.datasource.username=$DB_USERNAME -Dspring.datasource.password=$DB_PASSWORD -jar /usr/local/lib/inventory.jar