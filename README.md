# How to run it:
Create dataBase and run migrations:
`mvn flyway:migrate`

# Run application:

`mvn spring-boot:run`

# How to use it:

## curl:
`http://localhost:8080/doclist -u admin:admin` <br>
`http://localhost:8080/doclist -u ivan:ivan` <br>
`-X PUT http://localhost:8080/adddoc?nubmer=10&total=10.1 -u ivan:ivan` <br>
`-X DELETE http://localhost:8080/deldoc/nubmer=1 -u admin:admin` <br>

## postman:
Send GET to http://localhost:8080/doclist with basic auth (admin:admin) <br>
Send PUT to http://localhost:8080/adddoc with params number and total basic. basic auth (ivan:ivan) <br>
Send DELETE to http://localhost:8080/deldoc with path param number basic auth (admin:admin) <br>
