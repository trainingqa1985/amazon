package stepDef;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "stepDef",dryRun = false,
plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"})
public class RunCucumberTest {
	   @AfterClass
	    public static void generateReport() {
	        File reportOutputDirectory = new File("target/cucumber-reports");
	        List<String> jsonFiles = new ArrayList<>();
	        jsonFiles.add("target/cucumber-reports/Cucumber.json");

	        String buildNumber = "1";
	        String projectName = "Amazon Search";

	        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
	        configuration.setBuildNumber(buildNumber);

	        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
	        reportBuilder.generateReports();
	    }
}
