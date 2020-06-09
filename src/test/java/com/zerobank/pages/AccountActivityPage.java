package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountActivityPage extends BasePage{

    @FindBy(xpath = "//a[@href='#ui-tabs-1']")
    public WebElement showTransactionsTab;

    @FindBy(xpath = "//a[@href='#ui-tabs-2']")
    public WebElement findTransactionsTab;

    public void navigateToTab(String tabName){
        BrowserUtils.waitForPageToLoad(5);
        if (tabName.equals("Show Transactions") && showTransactionsTab.isEnabled()){
            showTransactionsTab.click();
        }
        if (tabName.equals("Find Transactions") && findTransactionsTab.isEnabled()){
            findTransactionsTab.click();
        }
    }

}
