# document-repository-sample

A working Spring Boot + Spring HATEOAS application implementing a hypermedia API supporting HAL <http://stateless.co/hal_specification.html>

Working solution to retrieve all the related one to many relationship docs. 
    
## Usage
### Running the Spring Boot app
Navigate to the directory into which you cloned the repo and execute this:
```
$ mvn spring-boot:run
```
  
Once started you can access the APIs on port 8080, e.g.
```
$ curl http://localhost:8080/projects
``` 
  
The port number can be changed by editing the port property in `src/main/resources/application.yml`  or setting the `server.port` property, e.g. `server.port=80`

  
### Load sample data

By default, the application database starts empty. 
To load sample data on start, launch the application with `-Dloadsampledata=true` 
```
$ mvn spring-boot:run -Dloadsampledata=true
```

### Running the executable JAR

`mvn package` creates an executable jar that may be launched directly

```

## License
