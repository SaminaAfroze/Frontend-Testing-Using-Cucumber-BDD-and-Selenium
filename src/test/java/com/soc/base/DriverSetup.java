package com.soc.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverSetup {

    WebDriver getWebDriverObject (DesiredCapabilities desiredCapabilities);
}
