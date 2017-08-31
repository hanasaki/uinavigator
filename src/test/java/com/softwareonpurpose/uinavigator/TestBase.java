package com.softwareonpurpose.uinavigator;

import com.softwareonpurpose.validator4test.Validator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;

public abstract class TestBase {
    void confirm(String result) {
        Assert.assertTrue(result.equals(Validator.PASS), result);
    }

    @AfterMethod(alwaysRun = true)
    protected void terminate() {
        UiHost.quitInstance();
    }

}
