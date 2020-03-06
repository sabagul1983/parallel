package com.argos.page_objects;

import com.argos.drivers.DriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

public class HomePage extends DriverManager {
    @FindBy(id = "searchTerm")
    private WebElement searchBox;

    public void doSearch(String searchTerm) {
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}
