package week4.day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("http://www.leafground.com/pages/Window.html");
	   
	   driver.findElement(By.id("home")).click();
		String Title = driver.getTitle();
		System.out.println(Title);
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String childwindow = windows.get(1);
		System.out.println(childwindow);
		
		driver.switchTo().window(childwindow);
		String title2 = driver.getTitle();
		System.out.println(title2);
		
		driver.switchTo().window(windows.get(0));
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		String Titlex = driver.getTitle();
		System.out.println(Titlex);
		
		Set<String> windowHandlesx = driver.getWindowHandles();
		List<String> windowsx = new ArrayList<String>(windowHandlesx);
		String childwindowx = windowsx.get(1);
		
		System.out.println(childwindowx);
		driver.switchTo().window( windowsx.get(0));  
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		String Titley = driver.getTitle();
		System.out.println(Titley);
		Set<String> windowHandlesy = driver.getWindowHandles();
		List<String> windowsy = new ArrayList<String>(windowHandlesx);
		String childwindowy = windowsy.get(2);
		
	}

}
