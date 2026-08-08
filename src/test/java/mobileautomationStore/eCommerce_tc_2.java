package mobileautomationStore;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseConfigurationStore {

	@Test
	public void Fillform() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Adailton");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
//		driver.executeScript("mobile: swipeGesture", Map.of(
//				"left", 0,
//			    "top", 0,
//			    "width", size.getWidth(),
//			    "height", size.getHeight(),
//			    "direction", "up",
//			    "percent", 0.15
//			));
		((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 0.75
			));

		int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for (int i = 0; i <productCount; i ++) {
			String prodcutName =	driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			System.out.println("product acont " + productCount + " " + prodcutName);
			if(prodcutName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				
			}
		}

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.attributeToBe(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		
		String pageInCart =  driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(pageInCart, "Jordan 6 Rings");
	}
}







