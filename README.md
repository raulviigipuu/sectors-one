# sectors-one

App tracking people's involvement with sectors

## run

    ./gradlew bootRun

    http://localhost:8080/

## test

    ./gradlew test

    firefox build/reports/tests/test/index.html

## build/run jar

    ./gradlew build
    java -jar build/libs/sectors-one-0.0.1-SNAPSHOT.jar

## dev

Profile **dev**

    ./gradlew bootRun --args='--spring.profiles.active=dev'

### h2 

Console url: **http://localhost:8080/h2**

### creating sql dump

https://www.h2database.com/html/commands.html#script

    SCRIPT TO 'dump.sql' CHARSET 'UTF-8';