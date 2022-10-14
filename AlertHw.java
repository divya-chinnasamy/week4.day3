package week4.day3;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHw {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//		//disable notifications
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/alert.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//clicking simple Alert box
		driver.findElement(By.xpath("//span[text()='Show']")).click();
		//switch to alert
		Alert alert = driver.switchTo().alert();
		//accepting the alert
		alert.accept();
		//verifying the result after accepting the alert
		System.out.println(driver.findElement(By.xpath("//span[@id='simple_result']")).getText());
		
		//confirm alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt93']/span[text()='Show']")).click();
		//switch to confirm alert
		Alert alert1 = driver.switchTo().alert();
		alert1.dismiss();
		System.out.println(driver.findElement(By.xpath("//span[@id='result']")).getText());
		
		//Sweet Alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt95']/span[2]")).click();
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']/span[2]")).click();
		
		//sweet modal dialog
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt100']//span[2]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='j_idt88:j_idt101_content']/p")).getText());
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-closethick']")).click(); ==> Not able to interact with this X element.
		Thread.sleep(3000);
		//Prompt Dialog Alert
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt104']")).click();
		Alert alert2 = driver.switchTo().alert();
		alert2.sendKeys("TestLeaf");
		alert2.accept();
		System.out.println(driver.findElement(By.xpath("//span[@id='confirm_result']")).getText());

		//Sweet Alert Confirmation
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt108']/span[2]")).click();
		
		//Minimize & Maximize dialog
		driver.findElement(By.xpath("//button[@id='j_idt88:j_idt111']/span[2]")).click();
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='j_idt88:j_idt112_content']/p")).getText());
	}

}
//https://www.leafground.com/alert.xhtml
