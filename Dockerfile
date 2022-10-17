FROM adoptopenjdk/openjdk11
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_marq21_bot
ENV BOT_TOKEN=5646202744:AAHa1QF1esFgBxE6BMP7neRBziIrUdM4o_A
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-jar", "/app.jar"]