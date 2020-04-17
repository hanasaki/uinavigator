package com.softwareonpurpose.uinavigator.web;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Test
public class WebUiElementBehaviorsTests {
    @AfterMethod
    public void terminate() {
        WebUiHost.quitInstance();
    }

    @Test
    public void testGetInstance_default() {
        Class expected = WebUiElementBehaviors.class;
        Class actual = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("body")).getClass();
        Assert.assertEquals(actual, expected, "Failed to return 'default' behaviors");
    }

    @Test
    public void testGetInstance_select() {
        Class expected = WebUiElementBehaviors.class;
        Class actual = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("select")).getClass();
        Assert.assertEquals(actual, expected, "Failed to return 'select' behaviors");
    }

    @Test
    public void testGetInstance_name() {
        Class expected = WebUiElementBehaviors.class;
        Class actual = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("name")).getClass();
        Assert.assertEquals(actual, expected, "Failed to return behaviors element with tag 'name'");
    }

    @Test
    public void testGet_web() {
        WebUiElementBehaviors behaviors = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("body"));
        Object actual = behaviors.get();
        String message = "Failed to return a Selenium RemoteWebElement";
        Assert.assertEquals(actual.getClass(), RemoteWebElement.class, message);
    }

    @Test
    public void testGetText_web() {
        WebUiElementBehaviors behaviors = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("body"));
        String expected = "";
        String actual = behaviors.getText();
        WebUiHost.quitInstance();
        String message = "Failed to return expected text";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testSet_web() {
        String uri = "file:///C:/Users/craig/Documents/git/uinavigator/src/test/resources/MockPage.html";
        WebUiHost.getInstance().load(uri);
        WebUiElementBehaviors behaviors = WebUiElementBehaviors.getInstanceByLocator(new By.ByName("user_name"));
        behaviors.set("Hello World");
        String expected = "Hello World";
        String actual = behaviors.getText();
        WebUiHost.quitInstance();
        String message = "Failed to return expected text";
        Assert.assertEquals(actual, expected, message);
    }

    @Test
    public void testGetList_web() {
        String uri = "file:///C:/Users/craig/Documents/git/uinavigator/src/test/resources/MockPage.html";
        WebUiElementBehaviors behaviors = WebUiElementBehaviors.getInstanceByLocator(new By.ByTagName("option"));
        WebUiHost.getInstance().load(uri);
        Class expected = ArrayList.class;
        Class actual = behaviors.getList().getClass();
        String message = "Failed to a collection of Selenium RemoteWebElement";
        Assert.assertEquals(actual, expected, message);
    }
}