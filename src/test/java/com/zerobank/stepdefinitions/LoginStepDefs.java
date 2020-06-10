package com.zerobank.stepdefinitions;

import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    //It takes 2 string as username and password and calls loginPage.login() method
    //Then asserts if the login is successful
    @Given("the user should be able to login with valid credentials {string} {string}")
    public void the_user_should_be_able_to_login_with_valid_credentials(String username, String password) {
        loginPage.login(username, password);
        BrowserUtils.waitForVisibility(dashboardPage.userIcon,5);
        Assert.assertEquals("Verify that user is on the Account Summary page",
                            "Zero - Account Summary", Driver.get().getTitle());
        System.out.println("Your positive login test was successful");
    }

    //It takes 2 string as username and password for each dataset in the Examples in the feature file
    //And calls loginPage.login() method
    //Then asserts if the login is unsuccessful
    @Then("the user should NOT be able to login with invalid credentials {string} {string}")
    public void the_user_should_NOT_be_able_to_login_with_invalid_credentials(String username, String password) {
        if (username.contains("blank")) {username = "";}
        if (password.contains("blank")) {password = "";}
        loginPage.login(username, password);
        Assert.assertTrue("Verify invalid credentials message is displayed",
                          loginPage.invalidCredentialsMessage.isDisplayed());
        System.out.println("Your negative login test was successful");
    }

    //It calls the loginPage.login() method
    @Given("the user can login successfully")
    public void the_user_can_login_successfully() {
        loginPage.login();
    }

}
