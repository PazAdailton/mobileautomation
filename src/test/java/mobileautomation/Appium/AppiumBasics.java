package mobileautomation.Appium;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class AppiumBasics extends BaseTest{
	
	@Test
	public void WifeSettingName() throws MalformedURLException, URISyntaxException {
		
		 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]\r\n"
		 		+ "")).click();
		 driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout\r\n"
		 		+ "")).click();
		 String alertTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]\r\n"
		 		+ "")).getText();
		 assertEquals(alertTitle, "WiFi settings");
		 //driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\r\n"
		 	//	+ "")).click();
		 driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		 driver.findElement(By.id("android:id/edit")).sendKeys("Adailton");
		 driver.findElement(By.id("android:id/button1")).click();
		 
		 
		 
	}
}
