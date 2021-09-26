package pageObjects;

import utils.DriverProvider;

public class BasePage<T> extends DriverProvider {

    protected final T ui;

    public BasePage(T ui) {
        this.ui = ui;
    }
}