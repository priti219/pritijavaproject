package com.unisuper.demo.report;

import org.testng.IExecutionListener;

/**
 * Created by pritig on 19/07/2017.
 */
public class TestNGExecutionListener implements IExecutionListener {
    @Override
    public void onExecutionStart() {
        System.out.println("TestNG is starting the execution");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Generating the Masterthought Report ...");
//        GenerateReportTestNG.GenerateMasterthoughtReport();
    }
}
