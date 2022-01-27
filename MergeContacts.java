package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {

public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leaftaps.com/opentaps");
driver.manage().window().maximize();
WebElement userName = driver.findElement(By.id("username"));
userName.sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Contacts")).click();
driver.findElement(By.linkText("Merge Contacts")).click();
driver.findElement(By.xpath("//input[@id='partyIdFrom']/following-sibling::a")).click();
Thread.sleep(8000);
Set<String> windowHandles = driver.getWindowHandles();
List<String> windows = new ArrayList<String>(windowHandles);
String childwindow = windows.get(1);
driver.switchTo().window(childwindow);
driver.findElement(By.xpath("(//div//a[@class='linktext'])[1]")).click();
Thread.sleep(800);
driver.switchTo().window(windows.get(0));
driver.findElement(By.xpath("//input[@id='partyIdTo']/following-sibling::a")).click();
Thread.sleep(7000);
Set<String> windHande = driver.getWindowHandles();
List<String> winow = new ArrayList<String>(windHande);
String childwindo = winow.get(1);
driver.switchTo().window(childwindo);
driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[2]//a")).click();
Thread.sleep(800);
driver.switchTo().window(windows.get(0));
driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
driver.switchTo().alert().accept();
String title = driver.getTitle();
System.out.println(title);
driver.close();
}}
