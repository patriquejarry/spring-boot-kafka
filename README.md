# Spring Boot - Kafka

Demo Kafka using Spring Boot

Thanks for 
* O Igor Rudel <https://www.youtube.com/watch?v=1p9mnguxKYQ>
* Rodrigo Freitas <https://www.youtube.com/watch?v=AzgryGuRzew>

---
---

## Install
(on each project)
* mvn clean install
* mvn clean package

## Run
* docker-composer up
* java -jar target/kafka-consumer-\<version>.jar
* java -jar target/kafka-producer-\<version>.jar

## API
* To send message
    * http://localhost:8080/producer/\<message>


