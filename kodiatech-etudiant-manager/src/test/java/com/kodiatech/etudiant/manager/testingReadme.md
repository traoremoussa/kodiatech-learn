[read baeldung](https://www.baeldung.com/spring-boot-testing)

[parti test](https://spring.io/guides/gs/spring-boot)

[Best way to testing ](https://medium.com/simform-engineering/testing-spring-boot-applications-best-practices-and-frameworks-6294e1068516)



In Spring testing, `@RunWith(SpringRunner.class)` and `@SpringBootTest` serve different purposes and are used in different contexts. Here’s a breakdown of each:

### @RunWith(SpringRunner.class)

- **Purpose**: This annotation is used to run your tests with the Spring TestContext Framework. It integrates the Spring Test framework with JUnit, allowing you to load the Spring application context for your tests.

- **Usage**: It is commonly used in combination with other Spring testing annotations, such as `@ContextConfiguration`, `@Test`, etc. This approach is typical in Spring applications before Spring Boot became popular.

- **Example**:

  ```java
  @RunWith(SpringRunner.class)
  @ContextConfiguration(classes = {MyConfig.class}) // Specify configuration classes
  public class MyTests {
      
      @Autowired
      private MyService myService;
      
      @Test
      public void testSomething() {
          // Test logic here
      }
  }
  ```

### @SpringBootTest

- **Purpose**: This annotation is specific to Spring Boot and is designed to provide a more comprehensive and convenient way to test Spring Boot applications. It automatically configures the application context, scans for Spring beans, and allows for integration testing.

- **Usage**: `@SpringBootTest` is typically used for integration tests, as it loads the full application context, including all beans, configuration, and properties defined in your Spring Boot application. It can also run with different profiles and customize the environment.

- **Example**:

  ```java
  @SpringBootTest
  public class MySpringBootTests {
      
      @Autowired
      private MyService myService;
      
      @Test
      public void testSomething() {
          // Test logic here
      }
  }
  ```

### Key Differences

1. **Context Loading**:
    - `@RunWith(SpringRunner.class)` requires you to specify the context configuration explicitly, while `@SpringBootTest` automatically loads the application context based on your Spring Boot configuration.

2. **Intended Use**:
    - `@RunWith(SpringRunner.class)` is more suited for traditional Spring applications, whereas `@SpringBootTest` is tailored for Spring Boot applications, making it easier to test features specific to Spring Boot.

3. **Ease of Use**:
    - `@SpringBootTest` simplifies testing by reducing the boilerplate code required to set up tests, particularly for integration testing.

### Conclusion

For modern Spring Boot applications, it is recommended to use `@SpringBootTest` as it leverages the conveniences of Spring Boot and simplifies the testing process. If you are working in a traditional Spring application or need fine-grained control over context loading, you might still use `@RunWith(SpringRunner.class)` along with specific context configurations.


### Liste 
 1.  `@RunWith(SpringRunner.class)` est une annotation utilisée dans JUnit 4 pour indiquer que
       SpringRunner (anciennement SpringJUnit4ClassRunner) doit être utilisé pour exécuter les tests. 
         Cela permet d’intégrer le framework Spring Test avec JUnit 4.
   le contexte Spring et d'activer des fonctionnalités comme l'injection de dépendances avec
`@Autowired` ou l'utilisation de `@MockBean`, `@TestConfiguration`, etc.
   ` @RunWith(SpringRunner.class) // Utiliser SpringRunner pour les tests Spring avec JUnit 4
   @SpringBootTest // Charger le contexte Spring complet
   public class MyServiceIntegrationTest {
   }
   }`

2. `@SpringBootTest` integration avec context global
3. `@ExtendWith(MockitoExtension.class)`dans les tests qui nécessitent l'utilisation de Mockito 
        pour simuler des dépendances

 4. `@AutoConfigureMockMvc` // test les endpoints REST
    est une annotation utilisée dans les tests d'intégration avec Spring Boot
  pour configurer automatiquement une instance de MockMvc. MockMvc permet de simuler des 
   appels HTTP et de tester les contrôleurs sans démarrer un serveur web réel.

5. `@DataJpaTest` : integration par defaut (configure une base de données embarquée (comme H2) pour les tests, 
  ce qui permet de tester les interactions avec la base de données sans nécessiter une base de données externe.)

6. `@AutoConfigureTestDatabase(replace = Replace.NONE)`
7. `@TestConfiguration`
8. `@Import(TestEmployeeServiceConfig.class)` importer la config
 - `@ActiveProfiles({"test","dev"})`
 - `RestTemplate`
 - `@WebMvcTest(MyController.class)`
 - 
 - `@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)`: dans context general, avec port variable

## resume à partir junit 5 
  1. @ExtendWith(MockitoExtension.class) :**Tests unitaires**  Cette annotation permet de configurer automatiquement 
   les mocks avec `@Mock`, `@InjectMocks`, et autres annotations de Mockito.

  2. `@AutoConfigureMockMvc`**Tests d'intégration**pour tester des endpoints HTTP sans démarrer un serveur complet.
    mais à  utiliser avec `@SpringBootTest` plus complet que `@WebMvcTest`

  3. `@WebMvcTest` :  que la partie controller , si ya les beans `MockBean` pour charger par exmple les services

### Bean 

- ` @MockBean` **tests Integration** **Test d'un contrôleur**Spring avec des services simulés
  Lorsque vous voulez tester un contrôleur, un service ou un composant Spring, 
et que vous avez des dépendances qui ne sont pas encore prêtes à être testées 
(par exemple des appels à une base de données ou des services externes).
- Elle est couramment utilisée avec `@WebMvcTest`, `@SpringBootTest` et d'autres
- annotations de test Spring pour injecter des versions simulées des beans dans le contexte Spring du test.
- `@Mock` **tests unitaires** qui ne dépendent pas de Spring, pour simuler des
  Utilisez-le avec MockitoJUnitRunner ou dans des classes de test avec `@ExtendWith(MockitoExtension.class).`
- `@MockMvc` : **Tester les contrôleurs** Spring sans serveur réel, **Test d'intégration** du Web Layer avec Spring MVC
Simule des requêtes HTTP sur des contrôleurs
  Utilisez @MockMvc pour tester les contrôleurs dans un environnement Spring sans démarrer 
- un serveur complet, et pour tester le comportement des requêtes HTTP (GET, POST, etc.).
- `@Spy` **tests unitaires** Modifier et surveiller des objets réels dans un test unitaire
## Resumer
 - `@MockMvc`
 - ` @MockBean`


- # dans teste integration on pas utilise mock (services)
-   @Autowired
- assertNotNull
- assertTrue
- assertEquals
- @Before
- @Test
- AssertThat

### Mehtode d'invocation
- ` verify`
- `when`
- `thenReturn`
- `@Spy`
### Summary

- **@Mock**: Use for creating mock objects in unit tests without a Spring context.
- **@MockBean**: Use in Spring Boot tests to replace a real bean in the application context with a mock, allowing for integration testing.
- **MockMvc**: Use for testing Spring MVC controllers by simulating HTTP requests and validating responses.

Yes, in addition to `@Mock` and `@MockBean`, there are several other mocking types and strategies available in various testing frameworks, particularly when working with Mockito and Spring. Here are some of the key types:

### 1. **@Spy**

- **Purpose**: The `@Spy` annotation is used to create a spy of a real object. Unlike a mock, which only allows you to define behavior, a spy can call the real methods of the object unless specifically stubbed.

- **Usage**: Use `@Spy` when you want to partially mock an object, allowing you to verify interactions while still executing the actual logic of some methods.


### 2. **@InjectMocks**

- **Purpose**: This annotation is used to create an instance of the class being tested and inject mock or spy instances into it. It helps set up the class under test with its dependencies.

- **Usage**: Typically used in conjunction with `@Mock` or `@Spy` to automatically inject mocks into the class being tested.

-

### 3. **Stubbing with Mockito**

- **Purpose**: Stubbing allows you to define specific responses for method calls on mock objects. You can customize the behavior of a mock based on the input parameters.

- **Usage**: Use the `when(...).thenReturn(...)` syntax to stub method calls.


### 4. **Argument Captors**

- **Purpose**: Argument captors allow you to capture arguments passed to a mocked method for verification purposes. This is useful when you want to assert that a specific value was passed to a method.

- **Usage**: Use the `ArgumentCaptor` class to capture and assert argument values.


### 5. **Custom Mocking Frameworks**

- **Purpose**: Beyond Mockito, there are other frameworks like JMock, EasyMock, and Powermock that offer additional mocking capabilities, such as mocking static methods or final classes.

### Summary

- **@Spy**: Partial mock of a real object.
- **@InjectMocks**: Automatically injects mocks into the class under test.
- **Stubbing**: Customize mock behavior using `when(...).thenReturn(...)`.
- **Argument Captors**: Capture arguments for verification.
- **Other Frameworks**: Explore JMock, EasyMock, and Powermock for advanced mocking scenarios.

In Mockito, the `verify` method is used to check that certain interactions with mock objects occurred during the execution of your tests. This allows you to ensure that methods on your mocks were called (or not called) with specific parameters, and it is essential for verifying the behavior of your code.

### Key Features of `verify`

1. **Method Invocation Verification**: You can check if a method was called on a mock object and how many times it was called.
2. **Argument Verification**: You can verify that a method was called with specific arguments.
3. **Times Verification**: You can specify how many times a method should have been called, which is useful for ensuring that your code behaves as expected.
4. **Optional Verification**: You can also verify that certain methods were not called.

### Basic Usage of `verify`

Here’s a simple example of how to use `verify` in a test case:

```java
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

public class MyServiceTest {

    @Test
    public void testSaveMethodCalled() {
        MyRepository myRepository = mock(MyRepository.class);
        MyService myService = new MyService(myRepository);

        myService.save(new MyEntity());

        // Verify that save method was called once with the specified argument
        verify(myRepository, times(1)).save(any(MyEntity.class));
    }
}
```

### Common `verify` Scenarios

1. **Verify Method Call**:

2. **Verify Call with Specific Arguments**:

3. **Verify Call Count**:
    - **Once**: Verifies that the method was called exactly once.

    - **At Least Once**: Verifies that the method was called at least once.
  
    - **Never**: Verifies that the method was never called.
   
    - **At Most**: Verifies that the method was called no more than a specified number of times.
  
4. **Argument Captors**:
   You can also capture arguments passed to mocked methods for further assertions:
   ```java


### Conclusion

The `verify` method is a powerful tool in Mockito that allows you to assert 
the expected interactions with your mocks. By using it effectively, you can ensur that your code behaves as intended and that the methods on your dependencies are called correctly during testing. This helps maintain the integrity of your unit tests and supports good testing practices.