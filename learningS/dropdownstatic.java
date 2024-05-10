package learningS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropdownstatic {
	
	
	
public static void main (String []args) throws InterruptedException {
	
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
         WebElement wb = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
         wb.click();
         Select select = new Select(wb);
         select.selectByIndex(1);

         Thread.sleep(3000)	;	
         select.selectByValue("AED");
         Assert.assertEquals(select.getFirstSelectedOption().getText(), "AED");

         Thread.sleep(3000)	;	
         select.selectByVisibleText("USD")	;	
         Assert.assertEquals(select.getFirstSelectedOption().getText(),"USD" );


		
		
	}

}
