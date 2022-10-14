package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//switch to frame
		driver.switchTo().frame(0);
		WebElement drag = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement drop = driver.findElement(By.xpath("//li[text()='Item 5']"));
		//calling action class
		Actions builder = new Actions(driver);
		//clicking and hold and moving to element 2
		builder.clickAndHold(drop).moveToElement(drag).perform();
		System.out.println("The elements sorted");
	}

}
