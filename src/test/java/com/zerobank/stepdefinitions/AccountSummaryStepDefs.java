package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.ShowTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {

    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    ShowTransactionsPage showTransactionsPage = new ShowTransactionsPage();
    DashboardPage dashboardPage = new DashboardPage();

    //It calls the dashboardPage.checkPageTitle() method
    @Then("{string} Page should have title {string}")
    public void page_should_have_title(String pageName, String title) {
        dashboardPage.checkPageTitle(pageName,title);
    }

    //It took expected account types and checked with the actual list
     @Then("Account summary page should have the following account types")
    public void account_summary_page_should_have_the_following_account_types(List<String> expectedList) {
        BrowserUtils.waitForVisibility(showTransactionsPage.table,5);
        List<String> actualList = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        Assert.assertEquals("Verify that the account types in the Account Summary page is correct",
                actualList, expectedList);
        System.out.println("The account types in the Account Summary page was checked");
    }

    //It took expected table columns and checked with the actual list
    @Then("{string} table should have the following columns")
    public void table_should_have_the_following(String accountType, List<String> expectedList) {
        BrowserUtils.waitForVisibility(showTransactionsPage.table,5);
        List<String> actualList = BrowserUtils.getElementsText(accountSummaryPage.creditAccountsTableColumns);
        Assert.assertEquals("Verify that the table columns on the " + accountType + " is correct",
                            actualList, expectedList);
        System.out.println("The table columns in the "+ accountType + " was checked");
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

}
