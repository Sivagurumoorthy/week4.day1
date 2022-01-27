package week4.day1;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class LearnFrame {
public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
	driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement findElement2 = driver.findElement(By.id("Click"));
		findElement2.click();
		String text3 = findElement2.getText();
		System.out.println(text3);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame(1);
	    WebElement findElement = driver.findElement(By.id("frame2"));
	    driver.switchTo().frame(findElement);
		WebElement findElement3 = driver.findElement(By.id("Click1"));
		File screenshotAs = findElement3.getScreenshotAs(OutputType.FILE);
		File destination = new File("./images/Frames.png");
		FileUtils.copyFile(screenshotAs, destination);
		findElement3.click();
		String text4 = findElement3.getText();
		System.out.println(text4);
		driver.switchTo().defaultContent();
		
		String text = driver.findElement(By.tagName("h1")).getText();
		System.out.println(text);
		List<WebElement> findElements = driver.findElements(By.xpath("//iframe"));
		int size = findElements.size();
		System.out.println(size);
		driver.switchTo().frame(2);
		 WebElement element = driver.findElement(By.xpath("//body[text()='Find total number of frames.']"));
	     String text2 = element.getText();
	     System.out.println(text2);
		
	   
	
		
	
	}
	
}
