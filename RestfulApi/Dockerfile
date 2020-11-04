# Use basic maven image
FROM maven:3.6.1

WORKDIR /

# Import source code for api into maven image
COPY RestfulApi/pom.xml /tmp/RestfulApi/pom.xml
COPY RestfulApi/src/main/java/server/RestfulServer.java /tmp/RestfulApi/src/main/java/server/RestfulServer.java

# Delete target directory, and then package
RUN mvn -f /tmp/ clean package

# Run the api
CMD java -jar /tmp/RestfulApi/target/RestfulApi-1.0-SNAPSHOT.jar
