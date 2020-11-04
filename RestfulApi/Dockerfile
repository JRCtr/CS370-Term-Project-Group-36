# Use basic maven image
FROM maven:3.6.1

WORKDIR /

# Import source code for api into maven image
COPY pom.xml /tmp/pom.xml
COPY src/main/java/server/RestfulServer.java /tmp/src/main/java/server/RestfulServer.java

# Delete target directory, and then package
RUN mvn -f /tmp/ clean package

# Run the api
CMD java -jar /tmp/target/RestfulApi-1.0-SNAPSHOT.jar
