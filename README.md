CharacterCounter
====

REST API, вычисляющее частоту встречи символов в заданной строке. 
Результат отсортирован по убыванию количества вхождений символа в заданную строку.

Сервис на Spring Boot 3 + Java 17.

Для сборки используется Maven.


===

Download and run:

    git clone https://github.com/AndreySerK/CharacterCounter
    cd */CharacterCounter  # Move to root directory
    maven install  # To create jar file
    java -jar */CharacterCounter-0.0.1-SNAPSHOT.jar # To run this service


Docker
===

    docker build -t <docker_image_name> . 
    docker run -p 8081:8081 <docker_image_name>

# API

### POST    /api/handler/string 

http://localhost:8081/api/handler/string

Request example (JSON):

{

"string": "ff ffD  DD11*"

}


Response example:

{

"result": {
"f": 4,
"D": 3,
"1": 2,
"*": 1
}

}
