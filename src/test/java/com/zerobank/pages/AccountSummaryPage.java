package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "//h2[@class='board-header']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "(//table)[3]/thead/tr/th")
    public List<WebElement> creditAccountsTableColumns;

}
