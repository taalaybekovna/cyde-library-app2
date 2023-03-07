package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UsersPage extends BasePage{

    // page_url = https://library2.cydeo.com/#users

        @FindBy(tagName = "th")
        public List<WebElement> usersTableHeader;

        // No page elements added

        public UsersPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }
    }

