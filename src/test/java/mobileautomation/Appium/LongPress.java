package mobileautomation.Appium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	@Test
	public void LongPressGesture() throws InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		WebElement element = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
		longPressAction(element);
//		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
//				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(),
//						"duration", 2000
//		));
		String menuText = driver.findElement(By.id("android:id/title")).getText();
		AssertJUnit.assertEquals(menuText, "Sample menu");
		AssertJUnit.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		
		
		
	}
}
