# Jersey Product Service

This Service was mafe to run in Tomcat as a docker image with all the dependencies provided at the image level.

The dependencies can be found in the dependencies folder.

The Server user Jersey to expose some Rest Services and connect to a Postgres database.

The connection information is found at the project level.


The application can be run as a Docker container.

Step 1:
```
maven clean package
```

Step 2:
```
docker build -t [image_name] .
```

Step 3:
```
docker run -p 8080:8080 [image_name]:[tag] 
```

---

Yopu shoud then be able to access the application at 
```
localhost:8080/productservice
```

The REST API consists of the following methods:

Method  |  URL  |  Action
--------|-------|--------------
GET | /api/product  | Retrieve all the products
GET | /api/products/{id} | Retrieve product with id  = {id}
GET | /api/product/search/{name} | Retrieve all products with {name}. Not case 
GET | /api/product/health | See if the service is up and running

---
##### The service can also be call using curl
```
curl -w "\n" url
```