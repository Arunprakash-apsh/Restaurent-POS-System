package com.company.automation.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        System.out.println("Starting Appium session...");

        UiAutomator2Options options = new UiAutomator2Options();

        // Device Info
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Newland NLS-MT93");
        options.setUdid("MT95LLHSGSEEH00503");

        // App Info
        options.setAppPackage("com.quinta.qpos");
        options.setAppActivity("com.quinta.qpos.activity.LoginPageActivity");
        options.setAppWaitActivity("com.quinta.qpos.activity.LoginPageActivity");
        options.setAppWaitDuration(Duration.ofSeconds(30));

        // 🔥 IMPORTANT FIX
        options.setNoReset(false); // MUST be false
        options.setFullReset(false);
        options.setAutoGrantPermissions(true);

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/"),
                options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("Session Created: " + driver.getSessionId());
    }

    @AfterMethod
    public void tearDown() {

        System.out.println("Closing Appium session...");

        if (driver != null) {
            driver.quit();
        }
    }
}
