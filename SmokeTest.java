package com.company.automation.tests;

import org.testng.annotations.Test;

import com.company.automation.base.BaseTest;

public class SmokeTest extends BaseTest {

    @Test(enabled = false)
    public void launchPOSApp() {
        System.out.println("POS App launched successfully");
    }
}
