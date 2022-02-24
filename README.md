# rest-service-app

Test offer project

A Springboot API that exposes two services, one that allows to register a user and a other that displays the details of a registered user.

A user is defined by: a user name, a birthdate, a country of residence, a phone number and a gender.

Only adult French residents are allowed to create an account!


## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `offer.test.airfrance.TechnicalProjectApplication` 
class from your favorite IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Database

In its default configuration (can be changed easily in the `application.properties` for any other database), the project use an in-memory database H2 (for easy local test without losing test data after every restart) 
which gets populated at startup with data.


## Swagger - Open api 3

To check out the swagger, open a browser and key in URL:

`http://localhost:8080/swagger-ui/index.html`

To check out openAPi 3, open a browser and key in URL:

`http://localhost:8080/v3/api-docs/swaggerhttp://localhost:8080/v3/api-docs/swagger`

## Postman collection

A postman collection is available in folder `postman/` you can find inside different use cases regarding the two services exposed by the application.

## Copyright
