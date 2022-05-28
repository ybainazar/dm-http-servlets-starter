# About:
Sample Web-application (MVC) based **ONLY** on Java Core (without Spring & Hibernate frameworks)

### Used libraries/technologies:
* Tomcat 10
* Jakarta Servlet JSTL API
* Servlet API
* Lombok
* JDBC (PostgreSQL (Sample Flight Dataset))
* JSP

### Functionality
* CRUD
* Utility 
    * Property handler
    * URL handler
    * JSP helper 
    * Connection manager (get connection to DB)
    * Date parser (String -> LocalDate)
* Validator
    * New User validation (name, gender, birthday)
* Servlets
    * Login/Logout within header for Session
    * Entity (flight, ticket and etc) servlets
    * Registration
    * Image upload/download
    * i18n/l10n for en_EN, ru_RU (translations bundle)
* Mappers from Entity <-> DTO
* Authorization & Authentication
* Filters
    * CharSet
    * Authorization based on User's role
    * Logging
* View layer is based on JSP + JSTL

# Architecture:
* __VIEW Layer__: HTML/JSP
* __CONTROLLER Layer__: Servlet (http)
* __MODEL Layer__: Service (dto) <-> DAO (entity) <-> PostgreSQL

# TODO
* Add multithreading for ConnectionManager via java.util.concurrent
* Add database migration
* Add testing (JUnit)
* Add building tool (Gradle)
* Rewrite Controller Layer -> Dispatcher Servlet + Controller
* Move to Spring Framework (Core, AOP, Security, Data JPA and Spring Boot) and ORM (Hibernate)
