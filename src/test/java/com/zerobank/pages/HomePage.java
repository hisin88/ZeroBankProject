package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".icon-signin")
    public WebElement signInButton;

    //It navigates the browser from home page to the login page
    public void signIn(){
        BrowserUtils.waitForClickability(signInButton,5);
        signInButton.click();
        System.out.println("You were on the homepage");
    }

}
