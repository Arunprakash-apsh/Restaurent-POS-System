package com.company.automation.tests;

import com.company.automation.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class LandingPageTest extends BaseTest {

    @Test
    public void verifyLandingPageIsLoaded() {
        System.out.println("🧪 Test Started...");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        try {
            // 🔍 DEBUG: What's on screen?
            debugScreen();

            // Wait & click Cloud Mode
            System.out.println("⏳ Waiting for Cloud Mode...");
            WebElement cloudMode = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.quinta.qpos:id/textViewCloudMode")));
            cloudMode.click();
            System.out.println("✅ Cloud Mode clicked");
            Thread.sleep(2000);

            // Test Server
            WebElement testServer = wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("com.quinta.qpos:id/textViewConnectTestServer")));
            testServer.click();
            System.out.println("✅ Test Server clicked");
            Thread.sleep(2000);

            // Yes confirmation
            wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1"))).click();
            System.out.println("✅ Confirmation clicked");
            Thread.sleep(2000);

            // License
            WebElement licenseField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.quinta.qpos:id/editTextLicenseKey")));
            licenseField.clear();
            licenseField.sendKeys("STKUX5FU");
            System.out.println("✅ License entered");
            Thread.sleep(2000);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("com.quinta.qpos:id/buttonSubmit"))).click();
            System.out.println("✅ License submitted");
            Thread.sleep(10000);

            // Username
            WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("com.quinta.qpos:id/editTextUserName")));
            userField.clear();
            userField.sendKeys("afcstoreadmin");
            System.out.println("✅ Username entered");
            Thread.sleep(2000);

            // Login
            wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/button1"))).click();
            System.out.println("✅ Login submitted");
            Thread.sleep(5000);

            System.out.println("🎉 FULL FLOW SUCCESS!");

        } catch (Exception e) {
            debugScreen();
            System.out.println("❌ FAILED: " + e.getMessage());
            Assert.fail("Test failed - see DEBUG above");
        }
    }

    private void debugScreen() {
        List<WebElement> textViews = driver.findElements(By.className("android.widget.TextView"));
        System.out.println("📋 DEBUG - " + textViews.size() + " TextViews found:");

        for (int i = 0; i < Math.min(10, textViews.size()); i++) {
            WebElement el = textViews.get(i);
            if (el.isDisplayed()) {
                String text = el.getText();
                String id = el.getAttribute("resource-id");
                System.out.println("  [" + i + "] '" + text + "' (id=" + id + ")");
            }
        }
        System.out.println("📱 Activity: " + driver.currentActivity());
    }
}
