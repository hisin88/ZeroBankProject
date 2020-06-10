package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PurchaseForeignCurrencyPage extends BasePage {

    @FindBy(xpath = "//select[@name='currency']")
    public WebElement currencyDropdown;

    @FindBy(id = "pc_amount")
    public WebElement amount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollarButton;

    @FindBy(id = "pc_inDollars_true")
    public WebElement selectedCurrencyButton;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostsButton;

}
