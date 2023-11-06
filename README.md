
# Spring Boot Assignment

This is a part of warm up Assignment that has basic arthmetic operation using Spring boot - Web.




## Deployment

To deploy this project run

### Build with maven
```bash
mvn clean install
```

### Run the JAR file.
```bash
  java -jar target/calculator-0.0.1-SNAPSHOT.jar
```


## API Reference

## Greeting API

```http
  GET /greetapi/v1/hello?name=Shantanu
```

| Search Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `name` | `string` | **Not Required** . Enter your name for greeting  |

## Calculator API

### Arthmetic Operation

```http
  GET /calculatorapi/v1/{operation}?number1=2&number2=4
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `operation`      | `string` | **Required**. Opreation available - `addition`  `subtraction`  `division`  `multiplication` |
| `number1`      | `double` | **Required**.  |
| `number2`      | `double` | **Required**.  |


### Square

```http
  GET /calculatorapi/v1/square/{number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`      | `double` | **Required**. Path Variable|

### Square Root

```http
  GET /calculatorapi/v1/squareroot/{number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`      | `double` | **Required**. Path Variable|

### Factorial

```http
  GET /calculatorapi/v1/factorial/{number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`      | `double` | **Required**. Path Variable|

### Min and Max

```http
  GET /calculatorapi/v1/min-max
```

Request Body
```
{ 
    "numbers" : [10,-5,7,15,-7,-6,16,19,-15,9] 
}
```




