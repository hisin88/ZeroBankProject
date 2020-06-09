package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{

    @FindBy(xpath = "//div[@class='offset2 span8']")
    public List<WebElement> accountTypes;

    @FindBy(xpath = "//div[@class='offset2 span8']/div[3]/div//tr")
    public List<WebElement> creditAccountsTableColumns;

}
