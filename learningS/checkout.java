package learningS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkout {
	
	
	
	public static void main (String []args) throws InterruptedException, ClassNotFoundException, SQLException{
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		Map<String,String> credMap = getCreds();
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(credMap.get("appUserName"));
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(credMap.get("appPassword"));
        driver.findElement(By.cssSelector("input[id='login-button']")).click();
        
        String producttext  = driver.findElement(By.xpath("//span[@class='title']")).getText();
        System.out.println(producttext);
        Thread.sleep(5674);
        if(producttext.equalsIgnoreCase("products")){
        
        System.out.println("login success");}
        else {
            System.out.println("login fail");}
        driver.manage().window().maximize();
        Thread.sleep(1000);
 
        driver.findElement(By.xpath(" //div[text()='Sauce Labs Bike Light']")).click();
        
        driver.findElement(By.xpath("//button[@id='add-to-cart']")).click();
   
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		
String checkitem =driver.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
System.out.println("selected item is"+checkitem);
String checkprice =driver.findElement(By.cssSelector("div[class='inventory_item_price']")).getText();
System.out.println("selected item price is"+checkprice);

driver.findElement(By.cssSelector("#checkout")).click();

driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("bhuvana");
driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("g");
driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("641006");

driver.findElement(By.xpath("//input[@id='continue' and @name ='continue']")).click();

String payinfo = driver.findElement(By.xpath("//div[text()='Payment Information:']")).getText();
System.out.println(payinfo);
String shipinfo = driver.findElement(By.xpath("//div[text()='Shipping Information:']")).getText();
System.out.println(shipinfo);

String itemtotal =driver.findElement(By.xpath("//div[@class='summary_subtotal_label']")).getText();
String[] arrayitt = itemtotal.split("\\$");
Double ittot =Double.valueOf(arrayitt[1]);
System.out.println(ittot);

String tax = driver.findElement(By.xpath("//div[@class='summary_tax_label']")).getText();
String []arraytax = tax.split("\\$");
Double taxx= Double.valueOf(arraytax[1]);
System.out.println(taxx);

String total  = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();

String [] totarray =total.split("\\$");
Double totall = Double.valueOf(totarray[1]);
System.out.println(totall);

Double totval = ittot + taxx;

if(totval==totall) {
	
	System.out.println(" price value is correct");
}
driver.findElement(By.xpath("//html/head/following-sibling::body/div/div/div/div[2]/div/div[2]/div[9]/button[2]")).click();

	}

public static Map<String,String> getCreds() throws ClassNotFoundException, SQLException{

    String url = "jdbc:mysql://localhost:3306/selenium";
    String username = "root";
    String password = "password";
    
    String appUserName = "";
    String appPassword = "";
    
    Map<String, String> credMap = new HashMap();

		    try( Connection connection = DriverManager.getConnection(url, username, password)){
		
		        // Creating Database Connection
		
		        Class.forName(
		                "com.mysql.cj.jdbc.Driver");//pom.xml library load pana
		        System.out.println("Connected to the database!");
		
		        // Create Statement
		        Statement stmt = connection.createStatement();
		
		        String selectSql = "SELECT * FROM login where type = 'standard'";
		
		   
		
		    try (ResultSet rs = stmt.executeQuery(selectSql)) {
		        while(rs.next()){
		            //Display values
		        	 appUserName = rs.getString("USER_NAME");
		             appPassword = rs.getString("PASSWORD");
		            
		            System.out.print("userName"  + appUserName);
		            System.out.print("password" + appPassword);
		      
		        }
		        
		        credMap.put("appUserName", appUserName);
		        credMap.put("appPassword", appPassword);
		        // use resultSet here
		    } catch (SQLException ex) {
		        throw new RuntimeException(ex);
		    }
		
		   
		}
    return credMap;
    
	}



}


