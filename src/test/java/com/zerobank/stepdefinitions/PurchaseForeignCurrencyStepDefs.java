package com.zerobank.stepdefinitions;

import com.zerobank.pages.PurchaseForeignCurrencyPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefs {

    PurchaseForeignCurrencyPage purchaseForeignCurrencyPage = new PurchaseForeignCurrencyPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedOptions) {
        BrowserUtils.waitForClickability(purchaseForeignCurrencyPage.currencyDropdown,5);
        Select select = new Select(purchaseForeignCurrencyPage.currencyDropdown);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());
        for (String each : expectedOptions){
            System.out.println(each);
            Assert.assertTrue("Verify that currency dropdown contains " + each,
                              actualOptions.contains(each));{
            }
        }
        System.out.println("All of the given currencies were available on the dropdown menu");
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        BrowserUtils.waitForVisibility(purchaseForeignCurrencyPage.amount,5);
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.amount.sendKeys("100");
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.dollarButton.click();
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.calculateCostsButton.click();
        BrowserUtils.waitFor(1);
        System.out.println("You tried to calculate w/o selecting a currency");
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        BrowserUtils.waitForClickability(purchaseForeignCurrencyPage.currencyDropdown,5);
        Select select = new Select(purchaseForeignCurrencyPage.currencyDropdown);
        select.selectByIndex(6);
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.dollarButton.click();
        BrowserUtils.waitFor(1);
        purchaseForeignCurrencyPage.calculateCostsButton.click();
        BrowserUtils.waitFor(1);
        System.out.println("You tried to calculate w/o entering a value");
    }

    @Then("error message should be displayed")
    public boolean error_message_should_be_displayed() {
        boolean result = true;
        Alert alert = Driver.get().switchTo().alert();
        String actual = alert.getText();
        String expected = "Please, ensure that you have filled all the required fields with valid values.";
        if (!actual.equals(expected)){
            System.out.println("Error message was not displayed on the screen");
            result = false;
        }
        System.out.println("Error message was displayed on the screen");
        return result;
    }

}
