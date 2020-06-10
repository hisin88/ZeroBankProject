package com.zerobank.stepdefinitions;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpLogin(Scenario scenario) {
        System.out.println(scenario.getName() + " started");
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("urlLogin"));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
            System.out.println("Test is failed on " + Driver.get().getTitle() + " page");
        }
        Driver.closeDriver();
        System.out.println(scenario.getName() + " ended");
    }

}
