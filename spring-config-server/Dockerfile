FROM openjdk:8
EXPOSE 8888
ADD target/spring-config-server.jar spring-config-server.jar 
ENTRYPOINT ["java","-jar","/spring-config-server.jar"]