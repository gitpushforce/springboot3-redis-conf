# Simple Redis Configuration (Spring Boot 3)

## Overview
This API is intended to show a simple redis configuration in Spring boot 3
using Java 17.<br>
It shows how to:

- set/get data to redis.<br>
- set a expiration time to the key.


## Specification
- Java 17
- Spring boot 3.1.2
- Gradle - Kotlin
- spring-boot-starter-data-redis 3.1.2
- Redis in Docker (image: redis:6.2-alpine)

## How to run
1) Build docker-compose to build Redis.
The file docker-compose is located in /docker folder

```bash
docker-compose up --build -d
```

2) Run this API using intellij or other IDE

3) Access to **http://localhost:8080/abc**

## What does this API do?
##### CASE 1:
If there is no value set in "val" key; it will be set.
The returned value will be the value set to redis (not retrieved from redis)

##### CASE 2:
If there is a value set in "val" key; nothing will be set to "val"
The returned value will be the retrieved value from redis.

**The expiration time of the redis key is 60 seconds. <br>
The expiration time can be modified in application.properties file**