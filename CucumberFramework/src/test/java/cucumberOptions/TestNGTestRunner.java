package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", monochrome = true, dryRun = false, tags = "@PlaceOrder or @OffersPage",
plugin= {"html:target/cucumber.html", "json:target/cucumber.json", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}

}



//maven run trough command line as below
//
//mvn test -Dcucumber.filter.tags="@PlaceOrder"
//
//cucumber.ansi-colors.disabled=  # true or false. default: false
//cucumber.execution.dry-run=     # true or false. default: false
//cucumber.execution.limit=       # number of scenarios to execute (CLI only).
//cucumber.execution.order=       # lexical, reverse, random or random:[seed] (CLI only). default: lexical
//cucumber.execution.wip=         # true or false. default: false.
//cucumber.features=              # comma separated paths to feature files. example: path/to/example.feature, path/to/other.feature
//cucumber.filter.name=           # regex. example: .*Hello.*
//cucumber.filter.tags=           # tag expression. example: @smoke and not @slow
//cucumber.glue=                  # comma separated package names. example: com.example.glue
//cucumber.plugin=                # comma separated plugin strings. example: pretty, json:path/to/report.json
//cucumber.object-factory=        # object factory class name. example: com.example.MyObjectFactory
//cucumber.snippet-type=          # underscore or camelcase. default: underscore