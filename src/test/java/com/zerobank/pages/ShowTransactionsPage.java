package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShowTransactionsPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(css = ".offset2.span8")
    public WebElement table;

    @FindBy(xpath = "(//table)/thead/tr/th")
    public List<WebElement> tableColumns;

    @FindBy(xpath = " //tr[3]//td[2]")
    public WebElement lastLine;

}
