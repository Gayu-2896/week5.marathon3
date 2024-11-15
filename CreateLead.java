package week5.marathon3;


import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {

	
		@DataProvider
		public String[][] sendData() {
			String[][] data=new String[2][4];
			data[0][0]="LeafTaps";
			data[0][1]="Gayathri";
			data[0][2]="J";
			data[0][3]="99";
			data[1][0]="LeafTaps";
			data[1][1]="Saranya";
			data[1][2]="S";
			data[1][3]="98";
		    return data;
		}
	

		@Test(dataProvider = "sendData")
		public void runCreateLead(String CName,String fName,String lName, String phNo) {
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CName);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (text.contains("Testleaf")) {
			System.out.println("Lead created successfully");
		}
		else {
			System.out.println("Lead is not created");
		}
		

	}

}

