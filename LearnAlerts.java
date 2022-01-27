package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver");
		// launch the Browser
		ChromeDriver driver = new ChromeDriver();
		// load the url
		driver.get("http://leafground.com/pages/Alert.html");
		// Maximize the browser
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(500);
		Alert alert3 = driver.switchTo().alert();
		String text4 = alert3.getText();
		System.out.println(text4);
		alert3.accept();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(500);
		Alert alert4 = driver.switchTo().alert();
		String text5 = alert4.getText();
		System.out.println(text5);
		alert4.accept();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
	Thread.sleep(1000);
	Alert alert = driver.switchTo().alert();
    String text =alert.getText();
	System.out.println(text);
	alert.sendKeys("ABC");
	alert.accept();
	driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
	Alert alert2 = driver.switchTo().alert();
	String text2 = alert2.getText();
	System.out.println(text2);
	alert2.accept();
	
	Thread.sleep(400);
	
	driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
   String text3 = driver.findElement(By.xpath("//div[text()='Happy Coding!']")).getText();
   System.out.println(text3);
   driver.findElement(By.xpath("//button[text()='OK']")).click();
   
	}}
