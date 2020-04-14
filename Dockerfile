FROM openjdk:14-alpine
ENV RANDOM_APP_USER duser
ENV RANDOM_APP_PASSWORD dpassword
ENV LOG_MESSAGE "default message"
EXPOSE 8080
VOLUME /usr/share/logs
RUN mkdir /app
COPY ./target/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "/app/app.jar"]