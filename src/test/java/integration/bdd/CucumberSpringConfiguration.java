package integration.bdd;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Cucumber Spring Configuration
 initializes the Spring context for Cucumber tests.
 Ensures that Cucumber can leverage Spring's dependency injection and configuration.
 */

@Configuration
@SpringBootConfiguration
@ComponentScan(basePackages = "com.ib.it")
public class CucumberSpringConfiguration {
    public CucumberSpringConfiguration() {
        System.out.println("CucumberSpringConfiguration constructor");
    }
}
