#!/bin/bash

git pull

mvn clean
mvn package

docker-compose stop

export BOT_NAME=$1
export BOT_TOKEN=$2
export BOT_DB_USERNAME='prod_tb_db_user'
export BOT_DB_PASSWORD='Pap9L9VVUkNYj99GCUCC3mJkb'

docker-compose up --build -d