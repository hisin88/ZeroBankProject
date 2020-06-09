package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import io.cucumber.java.en.Given;

public class AccountActivityStepDefs {

    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user is on the {string} tab")
    public void the_user_is_on_the_tab_on_the_page(String tabName) {
        accountActivityPage.navigateToTab(tabName);
        System.out.println("You were on the " + tabName + " tab");
    }

}
