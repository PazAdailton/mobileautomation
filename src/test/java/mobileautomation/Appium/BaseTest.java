package mobileautomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		// AndroidDriver and IOSDriver
		service =  new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\AdailtonPaz\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
			.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Xiaomi 2201117TG");
		options.setApp("C:\\Users\\AdailtonPaz\\eclipse-workspace_java_essencial\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
		options.setAutoGrantPermissions(true);
		
	    driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Xpath, id, accessibilityId, classname, androidUIAutomator
	}
	
	@AfterClass
	public void tearDown() {
	//	driver.quit();
		//service.stop();
	}
}
