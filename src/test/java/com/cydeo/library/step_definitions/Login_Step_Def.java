package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.jv.Lan;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Step_Def {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    LandingPage landingPage = new LandingPage();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("qa2_url"));
    }

    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("lib22_user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("lib22_pass"));
        loginPage.signinBtn.click();

    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expectedURL ="dashboard";

        wait.until(ExpectedConditions.urlContains(expectedURL));

        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("dashboard is not appear on URL",actualURL.contains(expectedURL));


    }

    @When("I login as a student")
    public void i_login_as_a_student() {

        loginPage.emailInput.sendKeys(ConfigurationReader.getProperty("student55_user"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperty("student55_pass"));
        loginPage.signinBtn.click();

    }
    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expectedUrl = "books";
        wait.until(ExpectedConditions.urlContains(expectedUrl));
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue("dashboard is not appear on URL",actualURL.contains(expectedUrl));


    }


    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.emailInput.sendKeys(username);

    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordInput.sendKeys(password);

    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signinBtn.click();

    }
    @When("there should be {int} users")
    public void there_should_be_users(Integer expectedUserCount) {

        String expectectedUserNum = String.valueOf(expectedUserCount);

        BrowserUtils.waitForVisibility(landingPage.userCount,10);
        String actualUserCount = landingPage.userCount.getText();
        Assert.assertEquals("User count is failing!",expectectedUserNum,actualUserCount);

    }

    @When("I login using {string} and {string}")
    public void i_login_using_and(String username, String password) {

        loginPage.emailInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.signinBtn.click();

    }

    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedUserName) {

        BrowserUtils.waitForVisibility(landingPage.userNameLink,10);
        String actualUserName = landingPage.userNameLink.getText();
        Assert.assertEquals(expectedUserName,actualUserName);


    }


}
