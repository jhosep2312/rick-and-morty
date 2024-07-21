# **CONSTRUCTORA BOLIVAR**
## rick-and-morty

This is the repo for rick-and-morty at Bolivar.

## Environment ⚙️
The following are the required ENV Vars that must be set to run the project.

- APP_NAME=rick-and-morthy
- DDL_AUTO=update
- HIBERNATE_DIALECT=org.hibernate.dialect.MySQLDialect
- UI_PATH=/swagger-ui.html
- MYSQL_HOST=bolivar-db-test.c5aoqae021zo.sa-east-1.rds.amazonaws.com
- DATABASE_USER=admin
- DATABASE_PASS=Bolivar12345*
- MYSQL_DB=bolivar-db-test
- MYSQL_DRIVER=com.mysql.cj.jdbc.Driver
- API_RM_URL=https://rickandmortyapi.com
- PI_RM_PATH=/api

## Stack 🛠️

- java 21
- mysql
- Hexagonal Architecture
- JPA
- AWS (RDS)
- Docker (Docker Compose) 
- [spring-boot 3](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
- [lombok](https://projectlombok.org/features/)

## Swagger 📝
### Swagger json
http://localhost:8080/api-docs

### Swagger UI
http://localhost:8080/swagger-ui/index.html


## Build in docker 🐋

### build in docker
```sh
docker compose build
```

### up in docker
```sh
docker compose up
```

## Descripcion en español

### Arquitectura 

La siguiente api realiza el crud de dos entidades (Characters y Locations ) para ello se implemento 
una arquitectura hexagonal con en la que se dejan explicitos los puertos de entrada y salida, en cuanto a los
adaptadores se dejaron implicitos, se usaron dos servicios que implementan sus respectivos repositorios 
que extienden de un repositorio generico tambien se implementaron diferentes patrones de diseño para el 
desarrollo 

### Instrucciones 
 
Se uso el servicio de RDS de AWS para tener una base de datos remota asi que no hay por que preocuparse por esa 
configuracion, la manera mas sencilla de probar los empoint es correr el proyecto en local ejecutando 
la clase principal y agregar el archivo bolivar.env que esta en la raiz del proyecto con esta extencion :

![Imagen](/ext_img.png)

luego dirigirse a la coleccion y probar cada empoint





