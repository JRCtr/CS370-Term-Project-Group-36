README
======
----DESCRIPTION----
Current version runs a RestfulAPI in a Docker Container. Later versions will include a second Docker Container, both Containers will be run in a Kubernetes Cluster. These will serve as a backend for an application that runs a simple game of Hangman.

All commands must be used while within the CS370-Term-Project-Group-36/ directory.

----USAGE----  
(currently, this is how you build and run the RESTful API, we are currently developing our actual program) 
To build, use mvn package.  
To run, use java -jar target/RestfulApi-1.0-SNAPSHOT.jar

----DOCKER----  
To build, docker build -tag RestfulApi  
To run, docker run -t -i ag  
