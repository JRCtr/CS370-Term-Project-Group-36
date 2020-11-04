# Use basic Ubuntu
FROM ubuntu

# Copy war file
COPY RestfulApi-1.0-SNAPSHOT.jar /RestfulApi.war

# Run the api
CMD ["/usr/bin/java", "-jar", "/RestfulApi.war"]
