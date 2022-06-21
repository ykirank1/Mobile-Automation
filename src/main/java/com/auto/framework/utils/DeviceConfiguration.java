package com.auto.framework.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class DeviceConfiguration {

	private DeviceConfiguration deviceConfiguration;
	private Properties deviceConfigProperties =new Properties();;

	public Properties getInstance() throws IOException {
		if (deviceConfiguration == null) {
			deviceConfiguration = new DeviceConfiguration();

			deviceConfigProperties = getDeviceConfigProperties();

		}
		return deviceConfigProperties;
	}

	private Properties readDeviceConfigProperties() throws IOException {
		InputStream inputStream = null;
		Properties prop = new Properties();
		try {
			String propFileName = "config.properties";

			inputStream = deviceConfiguration.getClass().getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}

	private Properties getDeviceConfigProperties() throws IOException {
		FileInputStream inputStream = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/config.properties");
		Properties prop = new Properties();
		try {
			String propFileName = "config.properties";
			
				System.out.println("Testing 123");
				prop.load(inputStream);
				System.out.println("Testing 1234");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
		return prop;
	}

	public String getOSVersion() {
		if (getDevicePlatform().equals(DeviceType.Android)) {
			return deviceConfigProperties.getProperty("ANDROID_DEVICE_OS_VERSION");
		} else {
			return deviceConfigProperties.getProperty("IOS_DEVICE_OS_VERSION");
		}
	}

	public DeviceType getDevicePlatform() {
		String platformName = deviceConfigProperties.getProperty("PLATFORM_NAME");
		System.out.println("Platform Name" + platformName);
		if (platformName.equalsIgnoreCase("android")) {
			System.out.println("Android Name" + platformName);
			return DeviceType.Android;
		} else {
			System.out.println("Android Name" + platformName);
			return DeviceType.Ios;
		}
	}

	public URL getAppiumURL() {
		URL url = null;
		try {
			url = new URL(deviceConfigProperties.getProperty("APPIUM_URL"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return url;
	}

	public String getDeviceUDID() {
		if (getDevicePlatform().equals(DeviceType.Android)) {
			return deviceConfigProperties.getProperty("ANDROID_DEVICE_UDID");
		} else {
			return deviceConfigProperties.getProperty("IOS_DEVICE_UDID");
		}
	}

	public String getAndroidVirtualDevice() {
		return deviceConfigProperties.getProperty("AVD_ID");
	}

	public String getAppPackage() {
		if (getDevicePlatform().equals(DeviceType.Android)) {
			return deviceConfigProperties.getProperty("ANDROID_APP_PACKAGE");
		} else {
			return deviceConfigProperties.getProperty("IOS_APP_PACKAGE");
		}
	}

	public String getAppPath() {
		if (getDevicePlatform().equals(DeviceType.Android)) {
			System.out.println("Android App Path");
			return deviceConfigProperties.getProperty("ANDROID_APP_PATH");
			
		} else {
			System.out.println("iOS App Path");
			return deviceConfigProperties.getProperty("IOS_APP_PATH");
		}
	}

	public String getDeviceName() {
		if (getDevicePlatform().equals(DeviceType.Android)) {
			return deviceConfigProperties.getProperty("ANDROID_DEVICE_NAME");
		} else {
			return deviceConfigProperties.getProperty("IOS_DEVICE_NAME");
		}
	}

}
