package com.softwareonpurpose.uinavigator.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebGetElementByLocatorAttributeParent implements WebGetElementBehavior {
    private final By locator;
    private final String attribute;
    private final String attributeValue;
    private final WebGetElementBehavior getParent;

    private WebGetElementByLocatorAttributeParent(
            By locator, String attribute, String attributeValue,
            WebGetElementBehavior getParent) {
        this.locator = locator;
        this.attribute = attribute;
        this.attributeValue = attributeValue;
        this.getParent = (getParent == null && new By.ByTagName("body").equals(locator)) ? null : getParent;
    }

    public static WebGetElementByLocatorAttributeParent getInstance(
            By locator, String attribute, String attributeValue,
            WebGetElementBehavior getParent) {
        return new WebGetElementByLocatorAttributeParent(locator, attribute, attributeValue, getParent);
    }

    @Override
    public WebElement execute() {
        List<WebElement> candidates;
        if (getParent == null) {
            candidates = WebUiHost.getInstance().findUiElements(locator);
        } else {
            candidates = getParent.execute().findElements(locator);
        }
        for (WebElement candidate : candidates) {
            final String attributeValue = candidate.getAttribute(this.attribute);
            if (attributeValue != null && attributeValue.equals(this.attributeValue)) {
                return candidate;
            }
        }
        return null;
    }
}
