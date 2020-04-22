package com.softwareonpurpose.uinavigator.web;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class WebGetByLocatorsOnlyTests {
    @Test
    public void testConstructor_class() {
        Class expected = WebGetElementBehavior.class;
        Class actual = WebGetElementByLocator.getInstance(new By.ByClassName("select")).getClass().getInterfaces()[0];
        Assert.assertEquals(actual, expected, "Failed:  constructor threw exception");
    }

    @Test
    public void testConstructor_id() {
        Class expected = WebGetElementBehavior.class;
        Class actual = WebGetElementByLocator.getInstance(new By.ById("elementID")).getClass().getInterfaces()[0];
        Assert.assertEquals(actual, expected, "Failed:  constructor threw exception");
    }

    @Test
    public void testConstructor_tag() {
        Class expected = WebGetElementBehavior.class;
        Class actual = WebGetElementByLocator.getInstance(new By.ByTagName("body")).getClass().getInterfaces()[0];
        Assert.assertEquals(actual, expected, "Failed:  constructor threw exception");
    }

    @Test
    public void testConstructor_name() {
        Class expected = WebGetElementBehavior.class;
        Class actual = WebGetElementByLocator.getInstance(new By.ByName("nameValue")).getClass().getInterfaces()[0];
        Assert.assertEquals(actual, expected, "Failed:  constructor threw exception");
    }

    @Test
    public void testConstructor_null() {
        Class expected = WebGetElementBehavior.class;
        Class actual = WebGetElementByLocator.getInstance(null).getClass().getInterfaces()[0];
        Assert.assertEquals(actual, expected, "Failed:  constructor threw exception");
    }
}
