##Microservices hexagonal architecture

This is a microservice that has the following features:

- Hexagonal architecture made with separate modules. The model layer has been made independent of any technology including spring 
- Centralized error handling. To make errors independent of the code, functional programming has been used and the composition technique has been prepared to be used.
- It has a Swagger that describes the possible actions.
- the dessign pattern used are followings one: 
	- ServiceLocator
	- Command
	- Adapter
	- CQRS
- The technique specifications used in the project are:
	- Java 17
	- Spring boot
	- Mapstruct
	- Lombok
	- h2
	 	
- he exposition of resources is provided at the following URL  url(http://localhost:8085/swagger-ui/index.html)