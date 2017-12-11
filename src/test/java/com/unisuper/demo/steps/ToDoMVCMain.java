package com.unisuper.demo.steps;

import com.unisuper.demo.pageclassfiles.ToDoMVCAngularJSClass;
import com.unisuper.demo.pageclassfiles.ToDoMVCHomePageClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.openqa.selenium.WebDriver;

/**
 * Created by pritig on 18/05/2017.
 */
public class ToDoMVCMain{

    ToDoMVCHomePageClass toDoMVCHomePageClass = new ToDoMVCHomePageClass();
    ToDoMVCAngularJSClass toDoMVCAngularJSClass = new ToDoMVCAngularJSClass();
    public WebDriver driver;

    public ToDoMVCMain(){
        driver = HookClass.driver;
    }

    @Given("^I am on ToDoMVC page$")
    public void iAmOnToDoMVCPage() throws Throwable {
        toDoMVCHomePageClass.iAmOnToDoMVCPage(driver);
    }

    @When("^I click on AngularJS$")
    public void iClickOnAngularJS() throws Throwable {
        toDoMVCHomePageClass.javaScriptNavigationLink("AngularJS",driver);
    }

    @Then("^AngularJS page should be displayed$")
    public void angularJSPageShouldBeDisplayed() throws Throwable {
        toDoMVCHomePageClass.angularJSPageShouldBeDisplayed(driver);
    }

    @Given("^I am on AngularJS page$")
    public void iAmOnAngularJSPage() throws Throwable {
    }

    @When("^I enter something in the ToDo text box$")
    public void iEnterSomethingInTheToDoTextbox() throws Throwable {
        toDoMVCAngularJSClass.iEnterSomethingInTheToDoTextbox(driver);
    }

    @Then("^a ToDo item should be added$")
    public void aToDoItemShouldBeAdded() throws Throwable {
       toDoMVCAngularJSClass.aToDoItemShouldBeAdded(driver);
    }
}



