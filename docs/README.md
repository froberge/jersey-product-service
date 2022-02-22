# Jersey Product Service

This Service was made to run in [Tomcat](http://tomcat.apache.org/) as a docker image using a *.war* binary with all the dependencies librairie provided inside Tomcat. This reduces the size of the war.

The required dependencies are found in the dependencies folder. If you need to add dependencies to the project, they need to be added in that folder for them to be used in the process of building the docker image.

The service uses [Eclispe Jersey](https://eclipse-ee4j.github.io/jersey/) to expose Jeysey RESTful webservice and connect to a [PostgresSQL](https://www.postgresql.org/) database.


The code used environment variable to connect to the required PostgreSQL database.

## Steps to build the image

1. Add the proper information in the file [docker/tomcat/env-files.txt](../docker/tomcat/env-files.txt).  There is 4 environment variable that need to be define.
```
POSTGRESQL_SERVICE_HOST=[HOST_NAME]
POSTGRESQL_DATABASE=[DATABASE_NAME]
POSTGRESQL_USER=[DB_USERNAME]
POSTGRESQL_PASSWORD=[DB_PASSWORD]
```

2. Build the application with maven
    ```
    mvn clean package
    ```
3. Build the docker image
    ```
    docker build -f docker/tomcat/Dockerfile -t [image_name] .
   ```


## Step to run the image

Once you have build the applicaiton, the only thing left to do it to run the docker image.

```
docker run -d --env-file docker/tomcat/env-file.txt --name=[POD_NAME] -p 8080:8080 [IMAGE_NAME]:[TAG] 
```

The appplication is accessible in your favorite browser at:
```
localhost:8080/productservice
```

or using curl
```
curl -w "\n" url
```

---
The REST API consists of the following methods:

Method  |  URL  |  Action
--------|-------|--------------
GET | /api/product  | Retrieve all the products
GET | /api/products/{id} | Retrieve product with id  = {id}
GET | /api/product/search/{name} | Retrieve all products with {name}. Not case 
GET | /api/product/health | See if the service is up and running
GET | /api/product/createschema | create the database schema
