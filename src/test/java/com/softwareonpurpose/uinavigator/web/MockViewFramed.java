package com.softwareonpurpose.uinavigator.web;

import com.softwareonpurpose.uinavigator.UiLocatorType;

public class MockViewFramed extends WebUiView {

    private static final String VIEW_URI = "file:///C:/Users/craig/Documents/git/uinavigator/src/test/resources/MockPage.html";
    private static final String LOCATOR_VALUE = "iframe";
    private static final String DESCRIPTION = "'Framed' view";

    public MockViewFramed() {
        super(VIEW_URI, WebUiElement.getInstance(DESCRIPTION, UiLocatorType.TAG, LOCATOR_VALUE));
    }

    public static MockViewFramed directNav() {
        MockViewFramed view = construct(MockViewFramed.class);
        view.load();
        view.switchTo();
        return WebUiView.expect(view.getClass());
    }

    @Override
    protected boolean confirmElementStates() {
        return this.getElement().waitUntilVisible();
    }
}
