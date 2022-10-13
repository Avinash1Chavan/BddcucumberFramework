package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/Login.feature"},
        glue={"stepdefinations","AppHooks"}
        //plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",}
)
public class RunnerWithTestng extends AbstractTestNGCucumberTests{

}
