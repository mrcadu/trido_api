FROM openjdk:12.0.1-jdk-oraclelinux7
VOLUME /opt
COPY build/libs/trido_api-0.0.1-SNAPSHOT.jar app.jar
RUN touch trido_api.log
CMD exec java -Djava.security.egd=file:/dev/./urandom -jar /app.jar > trido_api.log
