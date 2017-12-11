package com.unisuper.demo.pageclassfiles;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by pritig on 31/05/2017.
 */

public class ToDoMVCBaseClass {

    public String actPageTitle;

    public void pageTitle(String expPageTitle, WebDriver driver) throws Exception {

        actPageTitle = driver.getTitle();
        boolean flag = false;

        if (actPageTitle.equalsIgnoreCase(expPageTitle)) {
            flag = true;
            System.out.println("\n" + "On " + actPageTitle + " page");
        } else {
            Assert.assertTrue(flag,"\n" + "Incorrect Page " + actPageTitle );
        }
    }
}
