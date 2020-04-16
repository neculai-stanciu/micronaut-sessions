FROM openjdk:14-alpine
COPY target/surveys-api-*.jar surveys-api.jar
EXPOSE 8080
CMD ["java", "-Dcom.sun.management.jmxremote", "-Xmx128m", "-jar", "surveys-api.jar"]
