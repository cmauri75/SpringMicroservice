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
* SpringSecurityConfiguration.java contains config for using auth
* properties are moved on bootstrap.yml 'cause spring need to know BEFORE application starts where config is located, Spring needs to know where your Eureka Server is located and how it should search for configuration 
* Tests are integration test, call to service that invokes backend

### Okta
Provides SSO facility. Install via:
`
flatpak install flathub com.okta.developer.CLI
okta register
okta login
okta apps create
`
* Choose Web, Other, redirect url: https://localhost:8080/authorization-code/callback, Logout Redirect URI of https://localhost:8080
* Go to okta admin page, search for created application and get client-id and client-secret, these data should be put in deanonym-ui.properties


## discovery
Created via spring-boot with "eureka server" dependency, is used by other service for presenting themself to other
### Hot parts:
* Other service must know his address and specify it in their application.properties

## config
Created via spring-boot with "eureka server" and "Config server" dependencies, is used by other service in order to remove other configurations from internal files.
Will contain Okta config

### Hot parts:
* Other service must know his address and specify it in their application.properties, used for auth config (via Okta)
* in root path create daenonym-ui.properties with okta data, these will be served in: http://localhost:8888/deanonym-ui.properties
* Only apps wich are registered on okta can have properties, SERVICENAME-xxx.properties are also available via merge in hiearchical way


# Verifications for microservicing
* port exposing. Da verificare in base al servizio di orchestrazione utilizzato se fissare la porta o meno
* DataFiller. Da sostituire con un docker per i test (cambia anche H2 in postgres)
* Scrivere servizio di bulk load
* Tests: impostare sistema di integration test: DB di test, startare docker per backend, startare UI (ok) invocare servizio. 
