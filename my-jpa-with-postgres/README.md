# Spring boot JPA with postgres DB


Technologies used:

* Spring Boot 3.1.2
* Spring Data JPA (Hibernate 6 is the default JPA implementation)
* PostgreSQL 15
* Java 17
* Maven 3
* JUnit 5
* Spring Tests with [REST Assured](https://rest-assured.io/) to test the REST services
* Docker, [Testcontainers](https://testcontainers.com/) (for Spring integration tests using a container)

# Docker Command:
docker run --name pg1 -p 5432:5432 -e POSTGRES_USER=mkyong -e POSTGRES_PASSWORD=password -e POSTGRES_DB=mydb -d postgres:15-alpine