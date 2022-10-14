package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesSeleniumWebdriver {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Passing control to frame
		driver.switchTo().frame("frame1");
		//Click the text box "Click me"
		driver.findElement(By.xpath("//b[text()='Topic :']/following-sibling::input")).sendKeys("test msg typed");
		
		//Passing control to frame3
		driver.switchTo().frame("frame3");
		//clicking checkbox
		driver.findElement(By.xpath("//input[@id='a']")).click();
		//Pass comtrol outside the current frame
		driver.switchTo().defaultContent();
		//Passing control to frame2
		driver.switchTo().frame("frame2");
		//selecting animals using select class
		WebElement animal = driver.findElement(By.id("animals"));		
		Select selanimal = new Select(animal);	
		selanimal.selectByVisibleText("Avatar");
		System.out.println("Animal Selected");
	}

}
