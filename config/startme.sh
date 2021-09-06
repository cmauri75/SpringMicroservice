mvn spring-boot:run -Dspring-boot.run.jvmArguments="-Dspring.cloud.config.server.git.password=SimplePwd1"
or
docker run -p8888:8888 -e "spring.cloud.config.server.git.password=SimplePwd1" kite/microservice-docker-config:0.0.1-SNAPSHOT