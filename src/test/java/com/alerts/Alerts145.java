package com.coforge.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.coforge.utility.Helper;

public class Alerts145 {

	@Test
	public void TestPopups() throws Exception {

		WebDriver driver = Helper.startBrowser("Chrome");

		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();

		Thread.sleep(5000);

		Alert alert = driver.switchTo().alert();
		alert.accept();

		String result = driver.findElement(By.cssSelector("#result")).getText();

		System.out.println(result);

		Assert.assertEquals("You successfully clicked an alert", result);

		// JS Confirm - Dismiss / Cancel
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();

		Thread.sleep(5000);

		Alert alert2 = driver.switchTo().alert();
		alert2.dismiss();

		String result2 = driver.findElement(By.cssSelector("#result")).getText();

		System.out.println(result2);

		Assert.assertEquals("You clicked: Cancel", result2);

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();

		Thread.sleep(5000);

		Alert alert3 = driver.switchTo().alert();
		alert3.accept();

		String result3 = driver.findElement(By.cssSelector("#result")).getText();

		System.out.println(result3);

		Assert.assertEquals("You clicked: Ok", result3);

		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();

		Thread.sleep(5000);

		Alert alert4 = driver.switchTo().alert();
		alert4.sendKeys("Hello Sai");
		alert4.accept();

		String result4 = driver.findElement(By.cssSelector("#result")).getText();

		System.out.println(result4);

		Assert.assertEquals("You entered: Hello Sai", result4);

		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

		String result5 = driver
				.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credentials.')]"))
				.getText();

		Thread.sleep(8000);

		System.out.println(result5);

		Assert.assertEquals("Congratulations! You must have the proper credentials.", result5);

		driver.quit();
	}
}
