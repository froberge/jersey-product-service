# ProductService

This is a java service that is use to interact with the product of a given company or shop.

#Here how to [contribute](CONTRIBUTING.md)

This is a maven project so just import in your favorite IDE and it should work.

Should run in a multitude of application server.  Has been tested with:
* Wildfly 10.1 and 12.
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
##### The service can be tested using Postman using a JSON object using this information.
