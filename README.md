# Spring Boot Rest API

Basic useful feature list:

* GET request to /api/user/ returns a list of users
* GET request to /api/user/1 returns the user with ID 1
* POST request to /api/user/ with a user object as JSON creates a new user
* POST request to /api/user/collection with a user's list object as JSON creates a new users as a collection.
* PUT request to /api/user/3 with a user object as JSON updates the user with ID 3
* DELETE request to /api/user/4 deletes the user with ID 4
* DELETE request to /api/user/ deletes all the users


### For Tutorial Purpose, detailed explanation :

* @RestController : First of all, we are using Spring 4′s new @RestController annotation. This annotation eliminates the need of annotating each method with @ResponseBody. Under the hood, @RestController is itself annotated with @ResponseBody, and can be considered as combination of @Controller and @ResponseBody.

* @RequestBody : If a method parameter is annotated with @RequestBody, Spring will bind the incoming HTTP request body(for the URL mentioned in @RequestMapping for that method) to that parameter. While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the HTTP request body into domain object [deserialize request body to domain object], based on ACCEPT or Content-Type header present in request.

* @ResponseBody : If a method is annotated with @ResponseBody, Spring will bind the return value to outgoing HTTP response body. While doing that, Spring will [behind the scenes] use HTTP Message converters to convert the return value to HTTP response body [serialize the object to response body], based on Content-Type present in request HTTP header. As already mentioned, in Spring 4, you may stop using this annotation.

* ResponseEntity is a real deal. It represents the entire HTTP response. Good thing about it is that you can control anything that goes into it. You can specify status code, headers, and body. It comes with several constructors to carry the information you want to sent in HTTP Response.

* @PathVariable This annotation indicates that a method parameter should be bound to a URI template variable [the one in '{}'].

* Basically, @RestController , @RequestBody, ResponseEntity & @PathVariable are all you need to know to implement a REST API in Spring. Additionally, spring provides several support classes to help you implement something customized.

* MediaType : Although we didn’t, with @RequestMapping annotation, you can additionally, specify the MediaType to be produced or consumed (using produces or consumes attributes) by that particular controller method, to further narrow down the mapping.

### Testing the API:

Let’s run the application[from IDE or on command line]. To test this API, i will use an external client [POSTMAN](https://www.getpostman.com/) (An extension from CHROME). 

Apart from IDE, you can also run this app using following approaches.

java -jar path-to-jar on Project root , mvn spring-boot:run

For instance, in order to retrieve all users, the URL should be: 
http://localhost:8080/SpringBootRestApi/api/user/


### Writing REST Client using RestTemplate

To avoid using HTTP Apache Client, Spring’s RestTemplate comes to our Rescue.

RestTemplate provides higher level methods that correspond to each of the seven main HTTP methods that make invoking many RESTful services a one-liner and enforce REST best practices.

Spring Boot provides RestTemplateBuilder that can be used to customize the RestTemplate before calling the REST endpoints. Since in this post we are not customizing the REST template [No additional header e.g.], we may prefer to directly use RestTemplate.

Below shown are HTTP methods and corresponding RestTemplate methods to handle that type of HTTP request.

HTTP Methods and corresponding RestTemplate methods:

* HTTP GET : getForObject, getForEntity.
* HTTP PUT : put(String url, Object request, String… urlVariables).
* HTTP DELETE : delete.
* HTTP POST : postForLocation(String url, Object request, String… urlVariables), * postForObject(String url, Object request, Class responseType, String… uriVariables).
* HTTP HEAD : headForHeaders(String url, String… urlVariables).
* HTTP OPTIONS : optionsForAllow(String url, String… urlVariables).
* HTTP PATCH and others : exchange execute.


### Conclusion

Rest API with Spring Boot is no-different than with Spring MVC, only the underlying application differs. Spring boot quietly simplifies it, providing all the sugar required, while still not getting in your way, reducing the development time by many-fold, certainly worth giving a try.
