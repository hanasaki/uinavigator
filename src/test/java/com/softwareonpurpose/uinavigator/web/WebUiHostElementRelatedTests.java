package com.softwareonpurpose.uinavigator.web;

import com.softwareonpurpose.uinavigator.web.mock.MockView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class WebUiHostElementRelatedTests {
    @AfterMethod(alwaysRun = true)
    public void terminate() {
        WebUiHost.quitInstance();
    }

    @Test
    public void testFindUiElement_nonexistent() {
        WebElement expected = null;
        WebElement actual = WebUiHost.getInstance().findUiElement(new By.ById("non-existent"));
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Failed to return null for non-existent element");
    }

    @Test
    public void testWaitUntilVisible() {
        MockView.directNav();
        final WebUiHost host = WebUiHost.getInstance();
        final WebElement element = host.findUiElement(new By.ByName("nonexistent"));
        final boolean actual = host.waitUntilVisible(element);
        Assert.assertFalse(actual, "Failed to return false for nonexistent element");
    }
}