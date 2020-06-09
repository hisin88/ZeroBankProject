package com.zerobank.stepdefinitions;

import com.zerobank.pages.BasePage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    //It calls the homePage.signIn() method
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        homePage.signIn();
    }

    //It calls homePage.signIn() method to navigate to the login page
    //And calls login() method with valid credentials to log in
    @Given("the user can login successfully")
    public void the_user_can_login_successfully() {
        loginPage.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));
    }

    //It takes 2 string as username and password and calls loginPage.login() method
    //Then asserts if the login is successful
    @Given("the user should be able to login with valid credentials {string} {string}")
    public void the_user_should_be_able_to_login_with_valid_credentials(String username, String password) {
        loginPage.login(username, password);
        Assert.assertTrue("Verify user icon is displayed", basePage.userIcon.isDisplayed());
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

}
