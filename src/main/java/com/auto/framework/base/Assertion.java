package com.auto.framework.base;

import org.testng.Assert;

public class Assertion {

	public void AssertTrue(boolean bool, String Message) {
		Assert.assertTrue(bool);
		Log.info(Message);
	}

	public void AssertFalse(boolean bool, String Message) {
		Assert.assertFalse(bool);
		Log.info(Message);
	}

	public void AssertEquals(String Actual, String Expected, String Message) {
		Assert.assertEquals(Actual, Expected);
		Log.info(Message);
	}

}
