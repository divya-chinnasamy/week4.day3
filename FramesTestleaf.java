package week4.day3;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesTestleaf {

	private static List<WebElement> indElements;

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Passing control to frame
		driver.switchTo().frame(0);
		//Click the text box "Click me"
		driver.findElement(By.xpath("//button[@id='Click']")).click();
		String Text = driver.findElement(By.xpath("//button[@id='Click']")).getText();
		//Printing the text after click
		System.out.println(Text);
		driver.switchTo().defaultContent();
		
		//Count number of frames
		List<WebElement> frame = driver.findElements(By.tagName("iframe"));
	    System.out.println("Total number " + frame.size());
		
	    //Passing to nested frame	
	    driver.switchTo().frame(2);
	    System.out.println("In Frame 3");
	    driver.switchTo().frame("frame2");
	    System.out.println("In Nested frame");
	    driver.findElement(By.xpath("//button[text()='Click Me']")).click();
	    String text1 = driver.findElement(By.xpath("//button[@id='Click']")).getText();
	    System.out.println(text1);		
	    driver.switchTo().defaultContent();

	}

}
