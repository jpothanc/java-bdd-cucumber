package integration.bdd;

import io.cucumber.junit.platform.engine.Cucumber;


/**
 * Acts as the entry point for running Cucumber tests with JUnit 5.
 * Enables the discovery and execution of Cucumber feature files and step definition
 * Cucumber options such as path of feature files, glue code, and plugin can be specified here like below.
 *
 * @SelectClasspathResource("features")
 * @ConfigurationParameter(
 *         key = GLUE_PROPERTY_NAME,
 *         value = "integration.bdd.stepdefnitions")
 *
 * These can also be specified in a junit properties file - junit-platform.properties.
 * For this project, the Cucumber options are specified in the unit-platform.properties.
 */

@Cucumber
public final class CucumberEntryPointTest {
    public CucumberEntryPointTest() {
        System.out.println("RunCucumberTest constructor");
    }
}
