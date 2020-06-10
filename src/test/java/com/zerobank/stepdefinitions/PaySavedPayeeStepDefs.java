package com.zerobank.stepdefinitions;

import com.zerobank.pages.PaySavedPayeePage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PaySavedPayeeStepDefs {

    PaySavedPayeePage paySavedPayeePage = new PaySavedPayeePage();
    String errorCheck;

    //It takes the data from the feature file and fills in the input boxes and clicks pay button
    @When("user enter the following information {string} {string} {string}")
    public void user_enter_the_following_information(String amount, String date, String description) {
        if (amount.equals("blank")){amount = ""; errorCheck = "amount";}
        if (date.equals("blank")){date = ""; errorCheck = "date";}
        BrowserUtils.waitForVisibility(paySavedPayeePage.payButton,5);
        paySavedPayeePage.amountInputBox.sendKeys(amount);
        paySavedPayeePage.dateInputBox.sendKeys(date);
        paySavedPayeePage.descriptionInputBox.sendKeys(description);
        paySavedPayeePage.payButton.click();
        BrowserUtils.waitFor(1);
        System.out.println("You filled the table and clicked to the pay button");
    }

    //It checks the confirmation message is displayed with the appropriate information
    @Then("confirmation message should be displayed {string}")
    public void confirmation_message_should_be_displayed(String confirmationMessage) {
        BrowserUtils.waitForVisibility(paySavedPayeePage.confirmationMessage,5);
        String actualMessage = paySavedPayeePage.confirmationMessage.getText();
        Assert.assertEquals("Verify that confirmation message is displayed",
                actualMessage,confirmationMessage);
        System.out.println("Confirmation message was checked");
    }

    //It checks the error message is displayed with the blank amount and date information
    @Then("error message should be displayed {string}")
    public void error_message_should_be_displayed(String expectedErrorMessage) {
        String actualMessage = "";
        if (errorCheck.equals("amount")){
            actualMessage = paySavedPayeePage.amountInputBox.getAttribute("validationMessage");
        }
        if (errorCheck.equals("date")){
            actualMessage = paySavedPayeePage.dateInputBox.getAttribute("validationMessage");
        }
        Assert.assertEquals("Verify that confirmation message is displayed",
                            expectedErrorMessage,actualMessage);
        System.out.println("Error message was checked");
    }

    //It checks the confirmation message is not displayed with the inappropriate information
    @Then("confirmation message should not be displayed")
    public void confirmation_message_should_not_be_displayed() {
        BrowserUtils.waitFor(1);
        Assert.assertFalse("Verify that confirmation message is not displayed",
                paySavedPayeePage.confirmationMessage.isDisplayed());
        System.out.println("Confirmation message was checked");
    }

}