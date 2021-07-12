# Spring Boot RESTApi Project
This is simple Java/ Maven/SpringBoot application that can be used to extract the only numbers from the given input file.Given file can contains special characters, numbers, words etc

# How to Run
This application has embeded tomcat.
## To run the application locally:
- mvn clean install
- mvn spring-boot:run

Application runs from http://localhost:8081

# Create a resource

POST /api/number/extractor



``` json
**Request**
{
    "filePath" : "C:/Users/demo/Desktop/test.txt"
}
```

``` json
**Response**
{
    "Line Number 0": {
        "6 Found at Position ": 8,
        "7 Found at Position ": 9,
        "9 Found at Position ": 18
    },
    "Line Number 1": {
        "0 Found at Position ": 12,
        "8 Found at Position ": 7,
        "9 Found at Position ": 13
    },
    "Line Number 2": {
        "7 Found at Position ": 13,
        "8 Found at Position ": 6
    },
    "Line Number 4": {
        "4 Found at Position ": 13,
        "7 Found at Position ": 5,
        "8 Found at Position ": 12
    },
    "Line Number 9": {
        "9 Found at Position ": 11
    }
}
```

