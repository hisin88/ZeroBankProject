package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

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

    //It logs in with the valid credentials from configuration.properties
    public void login() {
        login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

}
