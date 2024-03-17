# myspringboot-collections
Collection of SpringBoot projects and Tools

### Terminologies

* Inversion of control
* Spring MVC
* Dispatcher Servlet
* Spring Bean (XML, Java Annotations or Java Code)
  * Bean lifecycle is managed by Spring container
  * @Configuration declare class as full configuration class
  * class must be non-final and public
  * @Bean declares bean configuration inside configuration class and this must be non-final and non-private
  * ![img.png](img.png)
  * ![img_1.png](img_1.png)
* Spring Component
  * @Component contains class-level annotation
  * Constructor dependency injection is automatically done using @Autowired (optional if there is only one constructor)
  * ![img_2.png](img_2.png)
  * @Repository, @Service and @Controller as meta-annotation for @Component that allows to further refine components
* Bean Naming
  * ![img_3.png](img_3.png)
* Dependency Injection:
  * Constructor Injection
  * Field Injection
  * Configuration Methods
  * Setter Methods Injection
* Constructor Injection
  * ![img_4.png](img_4.png)
  * We can specify @Qualifier to tell Spring to select or prioritize if 2 beans are of same type
  * ![img_6.png](img_6.png)
  * @Primary annotation can be used for this as well
  * ![img_7.png](img_7.png)
* Field Injection (Not recommended)
  * Direct injection as field without constructor or method declaration
  * ![img_8.png](img_8.png)
* Method Injections
  * One or many dependencies by one method
  * ![img_9.png](img_9.png)
* Setter Injection
  * Using setter method injection
    * ![img_10.png](img_10.png)

* Bean Scoping
  * Spring provides multiple scope
  * Default scope is "Singleton"
    * Singleton
    * Prototype
    * Request
    * Session
    * Application
    * Websocket
  * ![img_11.png](img_11.png)
* Bean Environment
  * Environment Abstraction
  * Injectable
* Bean Profiles
  * ![img_12.png](img_12.png)
  * We can set profiles programmatically
  * ![img_13.png](img_13.png)
  * ![img_14.png](img_14.png)
* @Value Annotation
  *  ![img_15.png](img_15.png)
  *  ![img_16.png](img_16.png)

*  Spring Best Practices
  * Split configuration classes
  * Import Configuration
  * ![img_17.png](img_17.png)

* Initialize Spring Projects from : https://start.spring.io/

* 