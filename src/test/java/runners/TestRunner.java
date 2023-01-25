package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "./src/test/resources/features", glue="steps",monochrome = true,
        dryRun = false,
        tags = "@CompleteSuite or @CurrentTest",
       // plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
        plugin = "html:target/report.html",
        publish=true
)

public class TestRunner extends AbstractTestNGCucumberTests
{
    @DataProvider
    public Object[][] getScenarios()
    {
        return super.scenarios();  
    }
}
