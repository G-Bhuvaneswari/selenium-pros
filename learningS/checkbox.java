package learningS;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
	       driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	        driver.manage().window().maximize();
	       Thread.sleep(3000);
	       driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	        driver.findElement(By.xpath("//a[@value='BLR']")).click();

	        	}
	       
	}


