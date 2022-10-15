#Pasos
##Generar el UberJar

Ingresar el directorio del proyecto donde se encuentra el archivo pom.xml
```
mvn clean install
```

## Ejecutar
```
java -jar target/mongodbatlasdriver-0.1-microbundle.jar                                                
```

## Se generan los enpoints
http://localhost:8080/

```
'ROOT' REST Endpoints:
GET     /api/application.wadl
GET     /api/country
GET     /api/country/{id}
GET     /api/hello
GET     /openapi/
GET     /openapi/application.wadl

]]

```

## Desde el navegador
Obtener todos los documentos
http://localhost:8080/api/country/

Buscar por idcountry=PA
http://localhost:8080/api/country/PA



## Shell

```
curl --location --request GET 'http://localhost:8080/api/country'

curl --location --request GET 'http://localhost:8080/api/country/PA'


curl --location --request POST 'http://localhost:8080/products/' \
--header 'Content-Type: application/json' \
--data-raw '{"id": 1, "name": "banana", "description": "a fruit", "rating": 5}'

curl --location --request POST 'http://localhost:8080/products/' \
--header 'Content-Type: application/json' \
--data-raw '{"id": 2, "name": "watermelon", "description": "watermelon sugar ahh", "rating": 4}'



curl -X PUT -H "Content-Type: application/json" -d '{"greeting" : "Hola"}' http://localhost:8080/greet/greeting


curl --location --request POST 'http://localhost:8080/api/oceano/' \
--header 'Content-Type: application/json' \
--data-raw '{"idoceano": "jr", "oceano": "Prueba"}'


```

## Metrics
```
http://localhost:8002/metrics

http://localhost:8002/api/metric/increment

http://localhost:8002/api/metric/timed

```