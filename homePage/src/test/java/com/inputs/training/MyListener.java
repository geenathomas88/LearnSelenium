package com.inputs.training;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class MyListener extends AbstractWebDriverEventListener{

	@Override
	public void afterNavigateBack(WebDriver driver) {
		System.out.println("Hello");
	}

}
