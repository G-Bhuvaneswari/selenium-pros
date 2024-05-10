package learningS;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class learn {
	
	public static void main(String[]args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		Thread.sleep(300);

		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("bhuvana");
		driver.findElement(By.cssSelector("input[name='inputPassword']  ")).sendKeys("Kbk@123");
		//driver.findElement(By.cssSelector(".submit signInBtn")).click();
	
	//driver.manage().deleteAllCookies();
		driver.findElement(By.linkText("Forgot your password?")).click();
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("bhuvana");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("krishbhuvan.7@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("7200751886");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).clear();
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("99999999999");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[text()='Reset Login']")).click();
        
        String str = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
      System.out.println(str);
        
        driver.close();
        driver.quit();
}
}