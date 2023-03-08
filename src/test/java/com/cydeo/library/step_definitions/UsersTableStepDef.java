package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTableStepDef {
    UsersPage usersPage = new UsersPage();

    @Given("I click on {string} link")
    public void i_click_on_link(String link) {
        BrowserUtils.waitForVisibility(usersPage.dashboardLink, 10);
        switch (link.toLowerCase()) {
            case "dashboard":
                usersPage.dashboardLink.click();
                break;
            case "users":
                usersPage.usersLink.click();
                break;
            case "books":
                usersPage.booksLink.click();
                break;
        }

    }

    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<WebElement> expectedTableHeader) {
        BrowserUtils.waitForVisibility(usersPage.usersLink, 10);
        List<String> actualTableHeader = BrowserUtils.getElementsText(usersPage.usersTableHeader);
        Assert.assertEquals(expectedTableHeader, actualTableHeader);

    }

}
