package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsPage extends BasePage{

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[1]")
    public List<WebElement> datesFound;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[2]")
    public List<WebElement> descriptionFound;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> depositFound;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> withdrawalFound;

    @FindBy(xpath = "//select[@name='type']")
    public WebElement typeSelectionDropdown;

    @FindBy(id = "filtered_transactions_for_account")
    public WebElement table;

}
