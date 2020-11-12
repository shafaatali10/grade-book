FROM openjdk:latest
COPY target/grade-book-1.0.jar /usr/src/grade-book-1.0.jar
sh java -jar /usr/src/grade-book-1.0.jar