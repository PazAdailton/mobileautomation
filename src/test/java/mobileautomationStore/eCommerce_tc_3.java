package mobileautomationStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseConfigurationStore {

	@Test
	public void Fillform() throws InterruptedException {
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Adailton");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		//driver.findElement(By.xpath("(//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
		wait.until(ExpectedConditions.attributeToBe(By.id("com.androidsample.generalstore:id/toolbar_title"), "text", "Cart"));
		
		String	productAmount = "";
		double totalProducts = 0;
		int countProduct = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		for(int i =0; i < countProduct; i++) {
		productAmount = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			totalProducts += getFormattedAmount(productAmount.replace("$", ""));
		}
		
		String totalPurchaseAmount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double totalPurchase = getFormattedAmount(totalPurchaseAmount.substring(1));
		Assert.assertEquals(totalProducts, totalPurchase);
		WebElement termsElement = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(termsElement);
		
		String alertTitle = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "Terms Of Conditions");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		//Hybrid - Google page
	}
}







