package com.unisuper.demo.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Created by pritig on 4/07/2017.
 */
public class ExtentReportsClass {

    ExtentReports extentReports;
    ExtentTest extentTest;

    @BeforeTest
    public void startReport(){
        extentReports =  new ExtentReports(System.getProperty("user.dir") + "/test-output/MyOwnReport.html", true);

        extentReports.addSystemInfo("Host Name", "Java Project")
                .addSystemInfo("Environment", "Automation Testing")
                .addSystemInfo("User Name", "Priti Gupta")
                .addSystemInfo("OS", "Windows 7");
        extentReports.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
    }
    @Test
    public void passTest(){
        extentTest = extentReports.startTest("passTest");
        Assert.assertTrue(true);
        extentTest.log(LogStatus.PASS, "Test Case Passed is passTest");
    }

    @Test
    public void failTest(){
        extentTest = extentReports.startTest("failTest");
        Assert.assertTrue(false);
        extentTest.log(LogStatus.FAIL, "Test Case (failTest) Status is passed");
    }

    @Test
    public void skipTest(){
        extentTest = extentReports.startTest("skipTest");
        throw new SkipException("Skipping - This is not ready for testing ");
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
            extentTest.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
        }else if(result.getStatus() == ITestResult.SKIP){
            extentTest.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
        }
        extentReports.endTest(extentTest);
    }

    @AfterTest
    public void endReport(){
        extentReports.flush();
        extentReports.close();
    }
}