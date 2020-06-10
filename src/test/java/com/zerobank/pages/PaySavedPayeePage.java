package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaySavedPayeePage extends BasePage{

    @FindBy(css = "#sp_amount")
    public WebElement amountInputBox;

    @FindBy(css = "#sp_date")
    public WebElement dateInputBox;

    @FindBy(css = "#sp_description")
    public WebElement descriptionInputBox;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement confirmationMessage;


}
