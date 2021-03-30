FROM openjdk:12-jdk-alpine
COPY ./build/libs/backend-barber-shop-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]