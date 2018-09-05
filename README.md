# ProductService

This service handle all the interaction with the product.
The code was made using a POSTGRESQL Database
The script to create the database can be found in the folder dbscripts
This is a maven project so just import in your favorite IDE and it should work.

#Here how to [contribute](CONTRIBUTING.md)

Should run in a multitude of application server.  Has been tested with:
* Wildfly 10.1 +
* Openshift Container Platform ( OCP ) using S2I

---

The REST API consists of the following methods:

Method  |  URL  |  Action
--------|-------|--------------
GET | /products  | Retrieve all the products
GET | /products/{id} | Retrieve product with id  = {id}
GET | /search/{name} | Retrieve all products with {name} in their name not case sensitive
GET | /createSchema | Create or recreate the product Schema

---
##### The service can be tested using Postman using a JSON object using this information