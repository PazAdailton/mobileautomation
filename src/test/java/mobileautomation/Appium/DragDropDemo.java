package mobileautomation.Appium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;

public class DragDropDemo extends BaseTest{

	@Test
	public void DragDropTest() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
		WebElement sourceDrag = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		dragAndDropAction(sourceDrag, 648, 605);
		String dropped = driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(dropped, "Dropped!");
		Assert.assertTrue(driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).isDisplayed());
		
		Thread.sleep(30000);

		}
}







