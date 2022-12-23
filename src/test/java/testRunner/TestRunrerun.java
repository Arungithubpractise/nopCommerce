package testRunner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"@target/failedrerun.txt"}, 
                 glue = "stepDefinitions", 
                 dryRun = false, 
                 monochrome = true, 
                 plugin = {"pretty", "html:test-output", "rerun:target/failedrerun.txt" },
                 tags = { "@regression,@sanity" }

)

public class TestRunrerun {

}

//tags={"@regression"} 
//tags={"@regression,@sanity"} = it is like and condition it executes both regression and sanity 
//tags={"@regression",@"@sanity",~@Endtoend} = regression, sanity will get execute end to end wont execute


