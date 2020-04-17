package com.softwareonpurpose.uinavigator.web;

import org.openqa.selenium.By;

public class WebGetElementProvider {
    public static WebGetElementBehavior getInstance(
            By locator,
            String attribute, String attributeValue,
            Integer ordinal,
            WebGetElementBehavior getParent) {
        return WebGetElementByLocator.getInstance(locator);
    }
}
