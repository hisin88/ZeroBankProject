package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

    @FindBy(xpath = "//a[@href='#ui-tabs-1']")
    public WebElement showTransactionsTab;

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransactionsTab;

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement addNewPayee;

    @FindBy(xpath = "//a[@href='#ui-tabs-3']")
    public WebElement purchaseForeignCurrency;

    //It takes a string pageName and if it is not the current page
    //it navigates the browser to new page
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String pageName) {
        if (!pageName.equals(activePage.getText())){
            String path = "//a[contains(text(),'" + pageName + "')]";
            Driver.get().findElement(By.xpath(path)).click();
        }
        System.out.println("You were on the " + pageName + " page");
    }

    //It takes a string tabName and if it is not the current page
    //it navigates the browser to new tab
    @Given("the user is on the {string} tab")
    public void the_user_is_on_the_tab_on_the_page(String tabName) {
        BrowserUtils.waitForPageToLoad(5);
        if (tabName.equals("Show Transactions") && showTransactionsTab.isEnabled()){
            showTransactionsTab.click();
        }
        if (tabName.equals("Find Transactions") && findTransactionsTab.isEnabled()){
            findTransactionsTab.click();
        }
        if (tabName.equals("Add New Payee") && addNewPayee.isEnabled()){
            addNewPayee.click();
        }
        if (tabName.equals("Purchase Foreign Currency") && purchaseForeignCurrency.isEnabled()){
            purchaseForeignCurrency.click();
        }
        System.out.println("You were on the " + tabName + " tab");
    }


    public void checkPageTitle(String pageName, String title) {
        BrowserUtils.waitForPageToLoad(5);
        Assert.assertEquals("Verify that the page title is correct",
                Driver.get().getTitle(), title);
        System.out.println(pageName + " page title was checked" );
    }

}
