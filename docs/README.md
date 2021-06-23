# Jersey Product Service

This Service was made to run in [Tomcat](http://tomcat.apache.org/) as a docker image using a *.war* binary with all the dependencies librairie provided inside Tomcat. This reduces the size of the war.

The required dependencies are found in the dependencies folder. If you need to add dependencies to the project, they need to be added in that folder for them to be used in the process of building the docker image.

The service uses [Eclispe Jersey](https://eclipse-ee4j.github.io/jersey/) to expose Jeysey RESTful webservice and connect to a [PostgresSQL](https://www.postgresql.org/) database.


There is 2 options to connect a database inside tomcat Webserver and run this application

#### Option #1 - Define database at the tomcat level

This options implies that everything runnign inside the tomcat uses the same database connection info. This option should be privilege for configuration that need to be generic.

###### Step to follow:

* Define the database connection by adding your database information in the following file *conf/context.xml*.
* Build the application with maven
    ```
    mvn clean package
    ```
* Build the docker image
    * execute the following command
    ```
    docker build -f docker/tomcat-no-context/Dockerfile -t [image_name] .
    ```

#### Option #2 - Define database at the application level
This options implies that only that application will be connected to the database instance. Give you more flexibility.

###### Step to follow:

* Define at the the database connection by adding a context.xml file in the following folder. *webapp/META-INF/context.xml*.  The file should look like that:
```
<?xml version='1.0' encoding='utf-8'?>

<Context>
    <!-- Database resource -->
    <Resource name="jdbc/postgres"
              auth="Container"
              type="javax.sql.DataSource"
              driverClassName="org.postgresql.Driver"
              username="DATABASE_USERNAME"
              password="DATABASE_PASSWORD"
              url="DATABASE_URL"
              maxTotal="20"
              maxIdle="10"
             maxWaitMillis="-1"/>
</Context>
```
* Build the application with maven
    ```
    mvn clean package
    ```
* Build the docker image
    ```
    docker build -f docker/tomcat-context/Dockerfile -t [image_name] .
    ```


#### Running the application

Once you have build the applicaiton using one of the previous options, the only thing left to do it to run the docker image.

```
docker run -p 8080:8080 [image_name]:[tag] 
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
