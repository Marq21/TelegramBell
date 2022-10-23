FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test_marq21_bot
ENV BOT_TOKEN=5646202744:AAHa1QF1esFgBxE6BMP7neRBziIrUdM4o_A
ENV BOT_DB_USERNAME=tb_db_user
ENV BOT_DB_PASSWORD=tb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]