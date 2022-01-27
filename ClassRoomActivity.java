package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoomActivity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver");
		// launch the Browser
		ChromeDriver driver = new ChromeDriver();
		// load the url
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt\r\n"+ "");
		// Maximize the browser
		driver.manage().window().maximize();
	//	driver.manage().timeouts(Duration.ofSeconds(10));
		Thread.sleep(6000);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("SIVA GURUMOORTHY");
		alert.accept();
		String id = driver.findElement(By.id("demo")).getText();
		System.out.println(id);
		
		
	}

}
