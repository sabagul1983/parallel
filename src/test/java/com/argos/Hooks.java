package com.argos;

import com.argos.drivers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
    private DriverManager driverManager= new DriverManager();
    @Before
    public void setUp(){
        driverManager.openBrowser();
        driverManager.maxBrowser();
        driverManager.navigateTo("https://www.argos.co.uk/");
        driverManager.applyImpcitWait();
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driverManager.closeBrowser();
    }
}
