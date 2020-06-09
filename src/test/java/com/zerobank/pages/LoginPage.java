package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "user_login")
    public WebElement usernameInputBox;

    @FindBy(id = "user_password")
    public WebElement passwordInputBox;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(css = ".alert.alert-error")
    public WebElement invalidCredentialsMessage;

    //It takes 2 string as username and password and tries to log in
    public void login(String username, String password){
        BrowserUtils.waitForClickability(usernameInputBox,5);
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        submitButton.click();
        System.out.println("You were on the login page");
    }

}
