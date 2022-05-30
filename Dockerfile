FROM openjdk:17
COPY ./build/libs/product-api-0.0.1-SNAPSHOT.jar product-api-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "product-api-0.0.1-SNAPSHOT.jar"]