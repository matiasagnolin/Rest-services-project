FROM nginx:alpine
MAINTAINER matias.agnolin@amaris.com
RUN apk add --no-cache openjdk8
WORKDIR /app
ADD target/RestApp.jar /app/RestApp.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app/RestApp.jar"]