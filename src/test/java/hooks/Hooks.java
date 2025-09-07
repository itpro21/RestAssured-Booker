package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void beforeScenario() {
        // Setup before each scenario if needed (e.g., base uri config)
        System.out.println("Starting scenario...");
    }

    @After
    public void afterScenario() {
        // Teardown after each scenario if needed
        System.out.println("Finished scenario.");
    }
}
