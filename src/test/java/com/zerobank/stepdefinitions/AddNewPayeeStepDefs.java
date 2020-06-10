package com.zerobank.stepdefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.AddNewPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDefs {

    AddNewPayeePage addNewPayeePage = new AddNewPayeePage();

    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        new DashboardPage().the_user_is_on_the_page(pageName);
    }

    @Given("the user is on the {string} tab")
    public void the_user_is_on_the_tab_on_the_page(String tabName) {
        new DashboardPage().the_user_is_on_the_tab_on_the_page(tabName);
    }

    @When("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> payeeInfo) {
        BrowserUtils.waitForVisibility(addNewPayeePage.payeeNameInputBox,5);
        addNewPayeePage.payeeNameInputBox.sendKeys(payeeInfo.get("Payee Name"));
        addNewPayeePage.payeeAddressInputBox.sendKeys(payeeInfo.get("Payee Address"));
        addNewPayeePage.payeeAccountInputBox.sendKeys(payeeInfo.get("Account"));
        addNewPayeePage.payeeDetailsInputBox.sendKeys(payeeInfo.get("Payee Details"));
        addNewPayeePage.addNewPayeeButton.click();
        System.out.println("You entered the given payee info to the table and clicked add button");
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals("Verify that correct message is displayed",
                            expectedMessage, addNewPayeePage.addNewPayeeMessage.getText());
        System.out.println("The alert message was displayed in correct content");
    }

}