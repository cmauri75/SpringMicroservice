# Important notes:
## Parent POM
* Not so important, is called aggregate project because it aggregates child projects. 
* It is useful for running the same Maven task on all declared modules. The modules do not need to use the root module as a parent.
## deanonym-service
Exposes services via rest
* Created using initalyzer with: Jdk1.8, JPA, Web, Lombok, H2

Starting service

        `mvn spring-boot:run`

### Hot parts:
* application.properties for port exposing
* DataFillerService support class for loading initial data

# Verifications for microservicing
* port exposing. Da verificare in base al servizio di orchestrazione utilizzato se fissare la porta o meno
* DataFiller. Da sostituire con un docker per i test (cambia anche H2 in postgres) e/o un servizio di bulk load
* Test: invocare il servizio

## deanonym-ui
Simple webapp for consuming services

Starting service

        `mvn spring-boot:run`

### Hot parts:
* BridgeController exposes index.html, that loads kite_users.js that via jquery invokes internal bridgeController that calls deanon using RestTemplate
* 