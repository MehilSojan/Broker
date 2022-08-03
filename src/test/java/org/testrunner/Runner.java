package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\resources\\FeatureFile", 
		glue = "org.test", 
		dryRun = false, 
		monochrome = true,
		plugin = { "pretty", "html:C:\\Users\\yuva\\Desktop\\NoBroker\\target\\Reports\\htmlReports.html"
}
)
public class Runner {
}
