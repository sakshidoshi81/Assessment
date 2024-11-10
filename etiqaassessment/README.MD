##### Etiqa_Assessmen_on_springboot #####
#####Document Created by Sakshi Doshi on 10/11/2024######

Spring boot application for Customer and product has created as per below config.

tools:
Spring MVC Framework
IntelliJ2024.2.4
Spring boot 3.3.5
Java 17 
Mysql
mySQLWorkbench
postman
Logback
GitHub

annotation :
1. @SpringBootApplication Annotation
This annotation is used to mark the main class of a Spring Boot application. It encapsulates @SpringBootConfiguration , @EnableAutoConfiguration , and @ComponentScan annotations with their default attributes.

2. @SpringBootConfiguration Annotation
It is a class-level annotation that is part of the Spring Boot framework. It implies that a class provides Spring Boot application configuration. It can be used as an alternative to Spring’s standard @Configuration annotation so that configuration can be found automatically. Most Spring Boot Applications use @SpringBootConfiguration via @SpringBootApplication. If an application uses @SpringBootApplication, it is already using @SpringBootConfiguration.

3. @EnableAutoConfiguration Annotation
This annotation auto-configures the beans that are present in the classpath. It simplifies the developer’s work by assuming the required beans from the classpath and configure it to run the application. This annotation is part of the spring boot framework.

4. @ComponentScan Annotation
@ComponentScan tells Spring in which packages you have annotated classes that should be managed by Spring. So, for example, if you have a class annotated with @Controller which is in a package that is not scanned by Spring, you will not be able to use it as a Spring controller. So we can say @ComponentScan enables Spring to scan for things like configurations, controllers, services, and other components that are defined. Generally, @ComponentScan annotation is used with @Configuration annotation to specify the package for Spring to scan for components.

5. @ConditionalOnClass Annotation and @ConditionalOnMissingClass Annotation
@ConditionalOnClass Annotation used to mark auto-configuration bean if the class in the annotation’s argument is present/absent.

6. @ConditionalOnBean Annotation and @ConditionalOnMissingBean Annotation
These annotations are used to let a bean be included based on the presence or absence of specific beans.

7. @ConditionalOnProperty Annotation
These annotations are used to let configuration be included based on the presence and value of a Spring Environment property.

8. @Controller Annotation
This annotation provides Spring MVC features. It is used to create Controller classes and simultaneously it handles the HTTP requests. Generally we use @Controller annotation with @RequestMapping annotation to map HTTP requests with methods inside a controller class.

9. @RestController Annotation
This annotation is used to handle REST APIs such as GET, PUT, POST, DELETE etc. and also used to create RESTful web services using Spring MVC.

10. @RequestMapping Annotation
This annotation is used to map the HTTP requests with the handler methods inside the controller class.

11. @RequestParam Annotation
This annotation is basically used to obtain a parameter from URI. In other words, we can say that @RequestParam annotation is used to read the form data and binds the web request parameter to a specific controller method.

12. @PathVariable Annotation
This annotation is used to extract the data from the URI path. It binds the URL template path variable with method variable.

13. @RequestBody Annotation
This annotation is used to convert HTTP requests from incoming JSON format to domain objects directly from request body. Here method parameter binds with the body of the HTTP request.

14. @ResponseBody Annotation
This annotation is used to convert the domain object into HTTP request in the form of JSON or any other text. Here, the return type of the method binds with the HTTP response body.

15. @ModelAttribute Annotation
This annotation refers to model object in Spring MVC. It can be used on methods or method arguments as well.
@EnableCaching
This annotation is used to enable caching in a Spring Boot application

16. @Configuration
This annotation indicating that an object is a source of bean definitions, it declares beans through @bean methods.

17. @PropertySource
This annotation is used to provide properties file to Spring Environment.

18. @EnableJpaRepositories
This annotation used to enable JPA repositories by using basePackages.

19. @Autowired
This annotation used for automatic dependency injection

20. @Priamry
This annotation used for to avoid diamond situation, to give higher preference to a bean when there are multiple beans of the same type like multiple databases.

21. @PostMapping
It is a shortcut for @RequestMapping annotation with method = RequestMethod.POST attribute

22. @GetMapping
It is a shortcut for @RequestMapping annotation with method = RequestMethod.GET attribute

23. @PutMapping
It is a shortcut for @RequestMapping annotation with method = RequestMethod.PUT attribute

24. @DeleteMapping
It is a shortcut for @RequestMapping annotation with method = RequestMethod.DELETE attribute

25. @Service
It is used to indicate that an annotated class is a “Service” which implements business logics relate to a particular domain of the application.



