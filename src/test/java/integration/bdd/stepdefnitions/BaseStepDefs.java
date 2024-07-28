package integration.bdd.stepdefnitions;

import com.ib.it.models.Book;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Base class for all step definitions.
 * Provides access to the WebTestClient and the response.
 * @CucumberContextConfiguration is an annotation provided by the cucumber-spring integration module.
 * It is used to specify a configuration class that sets up the Spring context for Cucumber tests.
 * This annotation helps bridge the gap between Cucumber and Spring,
 * ensuring that Cucumber tests can leverage Spring's dependency injection and other features.
 * You can only specify this at one place in your project.
 */
@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BaseStepDefs {
    @Autowired
    protected WebTestClient webTestClient;
    protected WebTestClient.ResponseSpec response;

    protected ParameterizedTypeReference<Book> getResponseType() {
        //ensures that the WebTestClient correctly deserializes the response into QueryResponse with a
        // nested list of Equity objects.
        return new ParameterizedTypeReference<Book>() {
        };
    }

}
