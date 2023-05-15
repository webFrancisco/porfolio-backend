FROM amazoncorretto:17
MAINTAINER webfrancisco
COPY target/PorfolioWebSpring-0.0.1-SNAPSHOT.jar PorfolioWebSpring-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/PorfolioWebSpring-0.0.1-SNAPSHOT.jar"]
