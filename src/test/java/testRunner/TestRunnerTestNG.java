package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        dryRun = false,
        monochrome = true,
        features = "classpath:features",
        glue = "stepDef",
//        features = "classpath:features_test",
//        glue = "stepDefTest",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		tags = "@login_logout"
)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}
