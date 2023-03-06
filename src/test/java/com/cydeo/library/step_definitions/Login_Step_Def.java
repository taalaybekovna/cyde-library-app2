package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtils;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_Step_Def {
    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);

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
    public void there_should_be_users(Integer int1) {

    }


}
