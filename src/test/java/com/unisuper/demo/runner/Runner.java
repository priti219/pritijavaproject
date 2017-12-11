package com.unisuper.demo.runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.File;

/**
 * Created by pritig on 22/06/2017.s
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/unisuper/demo/features"},
        glue = {"com.unisuper.demo.steps"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"}
)
public class Runner {
    @BeforeClass
    public static void setup(){
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("output/report.html");
    }
    @AfterClass
    public static void teardown(){
        Reporter.loadXMLConfig(new File("src/test/java/com/unisuper/demo/report/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}