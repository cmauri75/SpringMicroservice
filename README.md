# Important notes:
### Parent POM
* Not so important, is called aggregate project because it aggregates child projects. 
* It is useful for running the same Maven task on all declared modules. The modules do not need to use the root module as a parent.
### Services 
* Created by spring initializer, backend serve data, UI for access testing purpose

## deanonym-service
Exposes services via rest
* Created using initalyzer with: Jdk1.8, JPA, Web, Lombok, H2

Starting service `mvn spring-boot:run`

### Hot parts:
* application.properties for port exposing
* DataFillerService support class for loading initial data
* Tests are Unit testing, DataAccess & service mocking dataaccess part
## deanonym-ui
Simple webapp for consuming services

Starting service

        `mvn spring-boot:run`

### Hot parts:
* BridgeController exposes index.html, that loads kite_users.js that via jquery invokes internal bridgeController that calls deanon using RestTemplate
* RestTemplate creation must be specified as @LoadBalances, do eureka call is made instead of using url as a standard one
* Tests are integration test, call to service that invokes backend


## discovery
Created via spring-boot with "eureka server" dpendency, is used by other service for presenting themself to other
### Hot parts:
* Other service must know his address and specify it in their application.properties
* 


# Verifications for microservicing
* port exposing. Da verificare in base al servizio di orchestrazione utilizzato se fissare la porta o meno
* DataFiller. Da sostituire con un docker per i test (cambia anche H2 in postgres) 
* Scrivere servizio di bulk load
* Tests: impostare sistema di integration test: DB di test, startare docker per backend, startare UI (ok) invocare servizio. 