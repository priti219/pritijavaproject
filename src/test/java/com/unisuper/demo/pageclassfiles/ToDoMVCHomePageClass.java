package com.unisuper.demo.pageclassfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by pritig on 29/05/2017.
 */
public class ToDoMVCHomePageClass {

    ToDoMVCBaseClass toDoMVCBaseClass = new ToDoMVCBaseClass();

    public void iAmOnToDoMVCPage(WebDriver driver) throws Throwable {
      toDoMVCBaseClass.pageTitle("TodoMVC", driver);
    }

    public void javaScriptNavigationLink(String javaScriptNavigationLink, WebDriver driver) throws Throwable {
        if (javaScriptNavigationLink == "AngularJS") {
            driver.findElement(By.xpath("//a[text()='AngularJS']")).click();
            System.out.println("\n" + "Clicked on AngularJS");
        }
    }

    public void angularJSPageShouldBeDisplayed(WebDriver driver) throws Throwable {
        toDoMVCBaseClass.pageTitle("AngularJS • TodoMVC", driver);
    }
}