package mobileautomation.Appium;
import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class MisceallanousAppiumActions extends BaseTest{
	
	@Test
	public void WifeSettingName() throws MalformedURLException, URISyntaxException, InterruptedException {
		//adb shell dumpsys window | findstr "mCurrentFocus"
		//app package and app activity 
		//Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");

//		 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		 driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
		((JavascriptExecutor)driver).executeScript("mobile: startActivity", 
			ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies u0 io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		 driver.findElement(By.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout")).click();
		 
		 //landscape mode
		 DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		 driver.rotate(landscape);
		 String alertTitle = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"WiFi settings\"]")).getText();
		 assertEquals(alertTitle, "WiFi settings");
		 //copy paste
		 driver.setClipboardText("Adailton Wifi");
		 driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		 driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText()); //copy to clipboard - paste it clipboard
		 driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		 //driver.hideKeyboard();
		 driver.pressKey(new KeyEvent(AndroidKey.BACK));
		 driver.findElement(By.className("android.widget.Button")).click();
		 driver.pressKey(new KeyEvent(AndroidKey.HOME));
		 
		 
		 
		 
	}
}
