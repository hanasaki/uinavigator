package com.softwareonpurpose.uinavigator.web;

import com.softwareonpurpose.uinavigator.UiLocatorType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Test
public class WebGetListByLocatorAttributeOrdinalParentTagLocatorTests {
    @AfterMethod(alwaysRun = true)
    public void terminate() {
        WebUiHost.quitInstance();
    }

    @Test
    public void testExecute_bodyTag() {
        WebGetElementBehavior getParent = WebGetElementByLocator.getInstance(UiLocatorType.TAG, "form");
        Class<WebUiElement> expected = WebUiElement.class;
        MockView.directNav();
        final String attribute = "data-test";
        final String attributeValue = "view-element";
        final int ordinal = 1;
        final String locatorValue = "body";
        final WebGetListByLocatorAttributeOrdinalParent getBehavior =
                WebGetListByLocatorAttributeOrdinalParent.getInstance(
                        UiLocatorType.TAG, locatorValue, attribute, attributeValue, ordinal, getParent);
        //noinspection rawtypes
        Class actual = getBehavior.execute().iterator().next().getClass();
        Assert.assertEquals(actual, expected, "Failed to return a list of WebUiElement");
    }
}
