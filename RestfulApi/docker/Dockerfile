# Use basic maven image
FROM maven:3.6.1

# Import source code for api into maven image
COPY pom.xml /tmp/pom.xml
COPY src/main/java/server/RestfulServer.java /tmp/src/main/java/server/RestfulServer.java

RUN mvn package

EXPOSE 5536

# Run the api
CMD java -jar target/RestfulApi-1.0-SNAPSHOT.jar
