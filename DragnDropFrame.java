package week4.day3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragnDropFrame {

	public static void main(String[] args) {
		//Launching chrome driver
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		//draggaable
//		driver.switchTo().frame(0);
//		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
//		//getting location using getLoc method
//		Point location = drag.getLocation();
//		//calling actions class
//		Actions builder = new Actions(driver);
//		//dragging to given x,y loaction in the argument 
//		builder.dragAndDropBy(drag,200, 120).perform();
//		Point location1 = drag.getLocation();
//		System.out.println(location1);
//		driver.switchTo().defaultContent();

		//droppable
		driver.switchTo().frame(0);
		WebElement drag1 = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		//getting dropping location
		Point location2 = drop.getLocation();
		int x = location2.getX();
		int y = location2.getY();
		//calling action class
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(drag1, x, y).perform();
		System.out.println(location2);
		System.out.println(driver.findElement(By.xpath("//div[@id='droppable']")).getText());
	}

}
