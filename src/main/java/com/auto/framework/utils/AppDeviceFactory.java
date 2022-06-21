package com.auto.framework.utils;

import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.base.Strings;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppDeviceFactory {
	public AppiumDriver<?> driver;
	
	public AppDeviceFactory (AppiumDriver<?> driver) {
		this.driver=driver;
	}

	public AppiumDriver<?> createDriver(DeviceConfiguration deviceConfiguration) throws IOException {
		deviceConfiguration.getInstance();
		DeviceType type = deviceConfiguration.getDevicePlatform(); 
		if (type == null) {
			String platformName = JOptionPane.showInputDialog("Please Provide Platforms: Android/Ios");
			if (platformName.toLowerCase().contains("android")) {
				type = DeviceType.Android;
			} else {
				if (!platformName.toLowerCase().contains("ios")) {
					throw new IllegalArgumentException("No Platform available for provided value");
				}
				type = DeviceType.Ios;
			}
		}
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("forceMjsonwp", true);
		desiredCapabilities.setCapability("noReset", false);
		desiredCapabilities.setCapability("app", deviceConfiguration.getAppPath());
		desiredCapabilities.setCapability("clearSystemFiles", true);
		desiredCapabilities.setCapability("deviceName", deviceConfiguration.getDeviceName());
		desiredCapabilities.setCapability("autoWebView", "true");
		//desiredCapabilities.setCapability("newCommandTimeout", 20000);
		switch (type) {
		case Android:
//			if (!Strings.isNullOrEmpty(deviceConfiguration.getAndroidVirtualDevice())) {
//				desiredCapabilities.setCapability("avd", deviceConfiguration.getAndroidVirtualDevice());
//			}
			//desiredCapabilities.setCapability("commandTimeout", 20000);
			//desiredCapabilities.setCapability("overrideSession", true);
			desiredCapabilities.setCapability("dontStopAppOnReset", true);
			desiredCapabilities.setCapability("VERSION", "12.0");
			desiredCapabilities.setCapability("platformName","Android");
			//desiredCapabilities.setCapability("noSign", true);
			//desiredCapabilities.setCapability("autoLaunch", true);
			desiredCapabilities.setCapability("autoGrantPermissions", true);
			desiredCapabilities.setCapability("unicodeKeyboard", false);
			desiredCapabilities.setCapability("resetKeyboard", false);
			desiredCapabilities.setCapability("appPackage", (String) deviceConfiguration.getAppPackage());
			desiredCapabilities.setCapability("appActivity", "com.cnhi.service.app.staging.MainActivity");
			driver = new AndroidDriver<AndroidElement>(deviceConfiguration.getAppiumURL(),desiredCapabilities);
			return(AndroidDriver<?>) driver;
		case Ios:
			desiredCapabilities.setCapability("platformName","iOS");
			desiredCapabilities.setCapability("automationName", "XCUITEST");
			desiredCapabilities.setCapability("updateWDABundleId", "com.cnhi.service.app.staging");
			 	
			//desiredCapabilities.setCapability("useNewWDA", false);
			desiredCapabilities.setCapability("platformVersion", "15.2");
			desiredCapabilities.setCapability("showIOSLog", false);
			desiredCapabilities.setCapability("bundleId", (String) deviceConfiguration.getAppPackage());
			desiredCapabilities.setCapability("udid", deviceConfiguration.getDeviceUDID());
			desiredCapabilities.setCapability("xcodeSigningId", "iPhone Developer");
			desiredCapabilities.setCapability("xcodeOrgId", "Iveco");
			driver = new IOSDriver<IOSElement>(deviceConfiguration.getAppiumURL(),
					desiredCapabilities);
			return(IOSDriver<?>) driver;
		default:
			return null;
		}
	}
}
