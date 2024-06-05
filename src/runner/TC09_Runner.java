package runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Features/TC09.feature"
		,glue={"tc05"}
		,dryRun = false
		)

public class TC09_Runner {

}