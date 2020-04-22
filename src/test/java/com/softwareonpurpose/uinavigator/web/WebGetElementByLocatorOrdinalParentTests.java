package com.softwareonpurpose.uinavigator.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class WebGetElementByLocatorOrdinalParentTests {
    @AfterMethod
    public void terminate() {
        WebUiHost.quitInstance();
    }

    @Test
    public void testConstructor_bodyTagParentNull() {
        final By.ByTagName locator = new By.ByTagName("body");
        Class expected = WebGetElementByLocatorOrdinalParent.class;
        Class actual = WebGetElementByLocatorOrdinalParent.getInstance(locator, 2, null).getClass();
        final String message = "Failed to return an instance of WebGetElementByLocatorOrdinalParent";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testConstructor_bodyTag() {
        final By.ByTagName locator = new By.ByTagName("body");
        final WebGetElementByLocator getParent = WebGetElementByLocator.getInstance(new By.ByName("user_name"));
        Class expected = WebGetElementByLocatorOrdinalParent.class;
        Class actual = WebGetElementByLocatorOrdinalParent.getInstance(locator, 2, getParent).getClass();
        final String message = "Failed to return an instance of WebGetElementByLocatorOrdinalParent";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testConstructor_labelTagParentNull() {
        final By.ByTagName locator = new By.ByTagName("label");
        Class expected = WebGetElementByLocatorOrdinalParent.class;
        Class actual = WebGetElementByLocatorOrdinalParent.getInstance(locator, 2, null).getClass();
        final String message = "Failed to return an instance of WebGetElementByLocatorOrdinalParent";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testExecute_bodyTagParentNull() {
        final By.ByTagName locator = new By.ByTagName("body");
        final WebGetElementByLocatorOrdinalParent getBehavior =
                WebGetElementByLocatorOrdinalParent.getInstance(locator, 1, null);
        Class expected = RemoteWebElement.class;
        MockView.directNav();
        Class actual = getBehavior.execute().getClass();
        final String message = "Failed to return an instance of RemoteWebElement";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testExecute_ordinalNonExistent() {
        final By.ByTagName locator = new By.ByTagName("label");
        WebGetElementBehavior getParent = WebGetElementByLocator.getInstance(new By.ByTagName("form"));
        final WebGetElementByLocatorOrdinalParent getBehavior =
                WebGetElementByLocatorOrdinalParent.getInstance(locator, 4, getParent);
        MockView.directNav();
        final WebElement actual = getBehavior.execute();
        final String message = "Failed to return null when ordinal > list size";
        Assert.assertNull(actual, message);
    }
}
