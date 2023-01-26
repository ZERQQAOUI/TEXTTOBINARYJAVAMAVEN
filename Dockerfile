# Use an official Java runtime as the base image
FROM openjdk

# Set the working directory in the container
WORKDIR /TEXTTOBINARYJAVAMAVEN

# Copy the application jar and its dependencies to the container
COPY TEXTTOBINARYJAVAMAVEN/target/classes/org/example/TextToBinary.class .
#COPY target/lib lib

# Set environment variables
#ENV JAVA_OPTS="-Xmx1024m"

# Expose the application's port
#EXPOSE 8080

# Run the application
#CMD ["java", "-jar", "myapp.jar"]
