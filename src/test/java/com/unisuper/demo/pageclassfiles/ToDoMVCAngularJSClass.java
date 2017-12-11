package com.unisuper.demo.pageclassfiles;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by pritig on 31/05/2017.
 */
public class ToDoMVCAngularJSClass {

//    public WebDriver driver;

    public void iAmOnAngularJSPage() throws Throwable {
    }

    public void iEnterSomethingInTheToDoTextbox(WebDriver driver) throws Throwable {

        WebElement formNewToDo = driver.findElement(By.id("new-todo"));
        formNewToDo.click();
        formNewToDo.sendKeys("First ToDo item");
        formNewToDo.sendKeys(Keys.RETURN);
    }

    public void aToDoItemShouldBeAdded(WebDriver driver) throws Throwable {
        if (driver.findElement(By.className("ng-binding")).isEnabled()) {
            System.out.println("\n" + "ToDo item is added.");
        } else {
            System.out.println("\n" + "ToDo item is NOT added.");
        }
    }
}
