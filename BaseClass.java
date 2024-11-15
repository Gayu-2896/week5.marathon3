package week5.marathon3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

		public RemoteWebDriver driver;//declare driver globally to access with all the methods
		@Parameters({"browser","url","username","password"})
		@BeforeMethod
		public void preCondition(String browser,String url, String Uname, String Pword) {
			//copy all the common lines of code from createlead class
			//pre-condition commanlines of code
			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} 
			else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.findElement(By.id("username")).sendKeys(Uname);
			driver.findElement(By.id("password")).sendKeys(Pword);
			driver.findElement(By.className("decorativeSubmit")).click();
			driver.findElement(By.linkText("CRM/SFA")).click();
	}
		//post-condition commanlines of code
		@AfterMethod
		public void postConditions() {
			driver.close();}
}
