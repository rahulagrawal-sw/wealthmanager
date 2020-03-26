FROM openjdk:11.0.6-slim
EXPOSE 9080
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} wealthmanager.jar
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar /wealthmanager.jar"]
#ENTRYPOINT ["java","-jar","/wealthmanager.jar"]