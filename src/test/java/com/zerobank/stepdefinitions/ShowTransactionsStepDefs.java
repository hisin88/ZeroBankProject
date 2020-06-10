package com.zerobank.stepdefinitions;

import com.zerobank.pages.ShowTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ShowTransactionsStepDefs {

    ShowTransactionsPage showTransactionsPage = new ShowTransactionsPage();

    //It takes an expected option and checks the default value of account dropdown
    @Then("Account dropdown default option should be {string}")
    public void account_dropdown_default_option_should_be(String expectedOption) {
        BrowserUtils.waitForClickability(showTransactionsPage.accountDropdown,5);
        Select select = new Select(showTransactionsPage.accountDropdown);
        Assert.assertEquals("Verify the default option of the account dropdown",
                            select.getFirstSelectedOption().getText(), expectedOption);
        System.out.println("The default option of the account dropdown was checked");
    }

    //It takes an expected options list and checks the account dropdown options
    @Then("Account dropdown should have the following options")
    public void account_dropdown_should_have_the_following_options(List<String> expectedOptions) {
        BrowserUtils.waitForClickability(showTransactionsPage.accountDropdown,5);
        Select select = new Select(showTransactionsPage.accountDropdown);
        List<String> actualOptions = BrowserUtils.getElementsText(select.getOptions());
        System.out.println(actualOptions.toString());
        System.out.println(expectedOptions.toString());
        Assert.assertEquals("Verify that the account dropdown options",
                            actualOptions, expectedOptions);
        System.out.println("The account dropdown options were same with the expected list");
    }

    //It takes an expected list and checks the transactions table column names
    @Then("Transactions table should have the following options")
    public void transactions_table_should_have_the_following_options(List<String> expectedList) {
        BrowserUtils.waitForClickability(showTransactionsPage.lastLine,5);
        List<String> actualList = BrowserUtils.getElementsText(showTransactionsPage.tableColumns);
        System.out.println(actualList.toString());
        System.out.println(expectedList.toString());
        Assert.assertEquals("Verify that the transaction table columns",
                            actualList, expectedList);
        System.out.println("The transactions table columns were same with the expected list");
    }

    //It takes a string account type
    //And assert if it is selected on the dropdown on the Account Activity/Show Transactions page
    @Then("{string} should be selected on the Account Activity page")
    public void should_be_selected_on_the_Account_Activity_page(String accountType) {
        BrowserUtils.waitForClickability(showTransactionsPage.accountDropdown,5);
        BrowserUtils.waitFor(1);
        Select select = new Select(showTransactionsPage.accountDropdown);
        Assert.assertEquals("Verify the selected option",
                            select.getFirstSelectedOption().getText(),accountType);
        System.out.println("You were on the Account Activity page");
        System.out.println("The " + select.getFirstSelectedOption().getText() + " dropdown option is selected");
    }

}
