package learningS;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class dropdownloop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@id='divpaxinfo']")).click();

		for (int i = 0; i < 2; i++) {

			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();

		}

		for (int i = 0; i < 2; i++) {

			driver.findElement(By.xpath("//span[@id='hrefIncChd']")).click();

		}
		for (int i = 0; i < 1; i++) {

			driver.findElement(By.xpath("//span[@id='hrefIncInf']")).click();

		}

		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();

		WebElement wee = driver.findElement(By.id("divpaxinfo"));

		System.out.println(wee.getText());

		Assert.assertEquals(wee.getText(), "3 Adult, 2 Child, 1 Infant");

	}
}