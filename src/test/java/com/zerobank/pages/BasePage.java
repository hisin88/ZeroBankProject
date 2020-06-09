package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".icon-user")
    public WebElement userIcon;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement activePage;

    //It takes a string pageName and if it is not the current page
    //it navigates the browser to new page
    public void navigateToPage(String pageName) {
        if (!pageName.equals(activePage.getText())){
            String path = "//a[contains(text(),'" + pageName + "')]";
            Driver.get().findElement(By.xpath(path)).click();
        }
    }

}
