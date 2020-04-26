package com.softwareonpurpose.uinavigator.web;

import com.softwareonpurpose.uinavigator.UiLocatorType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class WebUiElementStateTests {
    @AfterMethod(alwaysRun = true)
    public void terminate() {
        WebUiHost.quitInstance();
    }

    @Test
    public void testSetActiveBehavior() {
        String activeValue = "active";
        WebUiElement element = WebUiElement.getInstance("Element", UiLocatorType.ID, "pet-select");
        element = element.setActiveBehavior("data-state", activeValue);
        Class<WebUiElement> expected = WebUiElement.class;
        Class actual = element.getClass();
        Assert.assertEquals(actual, expected, "Failed to return WebUiElement when 'active' state behavior set");
    }

    @Test
    public void testIsActive() {
        WebUiElement element = WebUiElement.getInstance("Element", UiLocatorType.ID, "empty-select");
        String attribute = "data-test";
        String value = "active";
        element.setActiveBehavior(attribute, value);
        boolean expected = true;
        MockView.directNav();
        boolean actual = element.isActive();
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Failed to return expected state");
    }

    @Test
    public void testIsSelected() {
        WebUiElement element = WebUiElement.getInstance("Element", UiLocatorType.ID, "button-1");
        String attribute = "data-selected";
        String value = "true";
        element.setSelectedBehavior(attribute, value);
        boolean expected = true;
        MockView.directNav();
        boolean actual = element.isSelected();
        //noinspection ConstantConditions
        Assert.assertEquals(actual, expected, "Failed to return expected state");
    }
}
