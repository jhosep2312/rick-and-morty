ARG BUILDER_IMAGE=amazoncorretto:21-alpine

FROM ${BUILDER_IMAGE}
COPY target/rick-and-morty-0.0.1-SNAPSHOT.jar bolivar-app.jar


ENTRYPOINT ["java", "-jar", "bolivar-app.jar"]

