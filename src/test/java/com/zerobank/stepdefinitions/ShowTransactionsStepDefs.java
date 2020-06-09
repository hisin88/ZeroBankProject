package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShowTransactionsStepDefs {

    BasePage basePage = new BasePage();

    //It takes the page name and call the basePage.navigateToPage method
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        basePage.navigateToPage(pageName);
        System.out.println("You were on the " + pageName + " page");
    }

    //It takes a string account type
    //And find and click on that account name on the Account Summary page
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String accountType) {
        String path = "//a[contains(text(),'" + accountType + "')]";
        BrowserUtils.waitForClickability(Driver.get().findElement(By.xpath(path)),5);
        BrowserUtils.waitFor(1);
        Driver.get().findElement(By.xpath(path)).click();
        System.out.println("You clicked on the " + accountType + " account");
    }

    //It takes a string account type
    //And assert if it is selected on the dropdown on the Account Activity/Show Transactions page
    @Then("{string} should be selected on the Account Activity page")
    public void should_be_selected_on_the_Account_Activity_page(String accountType) {
        String path = "//option[contains(text(),'" + accountType + "')]";
        WebElement selectedOption = Driver.get().findElement(By.xpath(path));
        BrowserUtils.waitForVisibility(selectedOption,5);
        BrowserUtils.waitFor(1);
        Assert.assertEquals("Verify the selected option", selectedOption.getText(),accountType);
        System.out.println("You were on the Account Activity page");
        System.out.println("The " + selectedOption.getText() + " dropdown option is selected");
    }

}
