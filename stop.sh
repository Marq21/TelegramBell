#!/bin/bash

# Ensure, that docker-compose stopped
docker-compose stopped

# Ensure, that the old application won't be deployed again.
mvn clean