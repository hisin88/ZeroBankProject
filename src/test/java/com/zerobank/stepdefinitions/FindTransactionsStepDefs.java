package com.zerobank.stepdefinitions;

import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {

    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitForClickability(findTransactionsPage.fromDate,5);
        BrowserUtils.waitFor(1);
        findTransactionsPage.fromDate.sendKeys(fromDate);
        BrowserUtils.waitFor(1);
        findTransactionsPage.toDate.sendKeys(toDate);
        System.out.println("You entered " + fromDate + " and " + toDate + " values");
    }

    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickability(findTransactionsPage.findButton,5);
        findTransactionsPage.findButton.click();
        System.out.println("You clicked to find button");
    }

    @Then("results table should only show transactions between {string} and {string}")
    public void results_table_should_only_show_transactions_between_and(String fromDateInput, String toDateInput) throws ParseException {
        BrowserUtils.waitForVisibility(findTransactionsPage.table,5);
        Assert.assertTrue("Verify that the dates on the table are between the given values",
                          checkDates(fromDateInput,toDateInput,findTransactionsPage.datesFound));
        System.out.println("Dates on the table are between the given date values");
    }

    public boolean checkDates(String fromDateInput, String toDateInput, List<WebElement> datesFound) throws ParseException {
        System.out.println("==========================================");
        boolean result = true;
        Date fromDate = new SimpleDateFormat("yyyy-MM-dd").parse(fromDateInput);
        Date toDate = new SimpleDateFormat("yyyy-MM-dd").parse(toDateInput);
        System.out.println("from date :" + fromDate);
        System.out.println("to date   :" + toDate);
        for (WebElement each : datesFound){
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(each.getText());
            System.out.println("date: " + date);
            System.out.println("date.compareTo(from date) --> " + date.compareTo(fromDate));
            System.out.println("date.compareTo(to date)   --> " + date.compareTo(toDate));
            if (date.compareTo(fromDate) < 0 && date.compareTo(toDate) > 0){
                result = false;
            }
        }
        System.out.println("==========================================");
        return result;
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {
        Assert.assertTrue("Verify that the dates on the table are sorted",
                          checkSorted(findTransactionsPage.datesFound));
        System.out.println("Dates on the table are sorted");
    }

    public boolean checkSorted(List<WebElement> datesFound) throws ParseException {
        System.out.println("==========================================");
        boolean result = true;
        for (int i=0 ; i<datesFound.size()-1 ; i++){
            Date datei = new SimpleDateFormat("yyyy-MM-dd").parse(datesFound.get(i).getText());
            Date datei1 = new SimpleDateFormat("yyyy-MM-dd").parse(datesFound.get(i+1).getText());
            System.out.println("datei  = " + datei);
            System.out.println("datei1 = " + datei1);
            System.out.println("datei.compareTo(datei1) = " + datei.compareTo(datei1));
            if (datei.compareTo(datei1) < 0 ){
                result = false;
            }
        }
        System.out.println("==========================================");
        return result;
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String searchWord) {
        BrowserUtils.waitForClickability(findTransactionsPage.descriptionInputBox,5);
        findTransactionsPage.descriptionInputBox.clear();
        BrowserUtils.waitFor(1);
        findTransactionsPage.descriptionInputBox.sendKeys(searchWord);
        System.out.println("You entered " + searchWord + " value");
        BrowserUtils.waitFor(1);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String searchWord) {
        Assert.assertTrue("Verify that the result table only show descriptions containing " + searchWord,
                          checkContains(searchWord));
        System.out.println("The result on the table only show descriptions containing " + searchWord);
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String searchWord) {
        Assert.assertFalse("Verify that the result table does not show descriptions containing " + searchWord,
                checkContains(searchWord));
        System.out.println("The result on the table does not show descriptions containing " + searchWord);
    }

    private boolean checkContains(String searchWord) {
        System.out.println("==========================================");
        boolean contain = true;
        BrowserUtils.waitForVisibility(findTransactionsPage.table,5);
        if (findTransactionsPage.descriptionFound.size() > 0){
            for (WebElement each : findTransactionsPage.descriptionFound){
                if (!each.getText().contains(searchWord)){
                    contain = false;
                    System.out.println("The " + each.getText() +
                            " result on the table does not show description containing " + searchWord);
                }else{
                    System.out.println("The " + each.getText() +
                            " on the table show description containing " + searchWord);
                }
            }
        }else {
            contain = false;
            System.out.println("The table is empty! There is no result related to your search word");
        }
        System.out.println("==========================================");
        return contain;
    }

    @When("user selects type {string}")
    public void user_selects_type(String searchType) {
        BrowserUtils.waitForClickability(findTransactionsPage.typeSelectionDropdown,5);
        Select select = new Select(findTransactionsPage.typeSelectionDropdown);
        select.selectByVisibleText(searchType);
        System.out.println("You selected " + searchType + " type from the dropdown");
    }

    @Then("results table should show appropriate result based on {string}")
    public void results_table_should_show_appropriate_result_based_on(String searchType) {
        Assert.assertTrue("Verify that the results on the table is appropriate",
                          checkAppropriate(searchType));
        System.out.println("The result table show appropriate result based on " + searchType + " type");
    }

    private boolean checkAppropriate(String searchType) {
        System.out.println("==========================================");
        boolean result = false;
        BrowserUtils.waitForVisibility(findTransactionsPage.table,5);
        List<WebElement> depositFound = findTransactionsPage.depositFound;
        List<WebElement> withdrawalFound = findTransactionsPage.withdrawalFound;
        switch (searchType){
            case "Any":
                if (checkFound(depositFound) && checkFound(withdrawalFound)){
                    result = true;
                }
                break;
            case "Deposit":
                if (checkFound(depositFound) && !checkFound(withdrawalFound)){
                    result = true;
                }
                break;
            case "Withdrawal":
                if (!checkFound(depositFound) && checkFound(withdrawalFound)){
                    result = true;
                }
        }
        System.out.println("==========================================");
        return result;
    }

    private boolean checkFound(List<WebElement> found) {
        System.out.println(found.size());
        for (WebElement each : found){
            System.out.println(each.getText());
            if (!each.getText().isEmpty()){
                System.out.println("There is at least one record under deposit");
                return true;
            }
        }
        System.out.println("checkFound() --> table is empty");
        return false;
    }

}