package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceNow1 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
	driver.get("https://dev101786.service-now.com/nav_to.do?");
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("XYZ123a#",Keys.ENTER);
	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@placeholder='Filter navigator']")).sendKeys("incident",Keys.ENTER);
	Thread.sleep(500);
	driver.findElement(By.xpath("//div[@class='sn-widget-list-title'][text()='Create New']")).click();
	Thread.sleep(500);
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
	  WebElement incidentno = driver.findElement(By.xpath("//input[@id='incident.number']"));
	  String attribute = incidentno.getAttribute("value");
	  System.out.println(attribute);
	Set<String> windowHandles1 = driver.getWindowHandles();
	List<String>windows1=new ArrayList<String>(windowHandles1);
	driver.switchTo().window(windows1.get(1));
	driver.findElement(By.xpath("//a[text()='Creator User']")).click();
	driver.switchTo().window(windows1.get(0));
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("CREATOR USER");
    driver.findElement(By.xpath("//button[@class='form_action_button  action_context btn btn-default']")).click();
    driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(attribute,Keys.ENTER);
    
    WebElement element = driver.findElement(By.xpath("//a[@class='linked formlink']"));
     String incidentcreate = element.getText();
    System.out.println(incidentcreate);
    
    
    if (attribute.equalsIgnoreCase(incidentcreate)) {
    	System.out.println(" SUCCESSFULL");
    } else {
    	System.out.println("NOT SUCCESSFULL");
    }
    File screenshot= driver.getScreenshotAs(OutputType.FILE);
	File destination= new File("./images/Servicenow.png");
	FileUtils.copyFile(screenshot, destination);
}

}
