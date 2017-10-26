package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class NewTest {
	
	public static WebDriver d;
	
	@Test

	public void test()
	{
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("https://www.google.com");
		String mainwnd = d.getWindowHandle();
		WebElement img = d.findElement(By.linkText("Images"));
		Actions act = new Actions(d);
		act.moveToElement(img).contextClick().sendKeys(Keys.chord(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ENTER)).build().perform();
		Set<String> allwnds = d.getWindowHandles();
		
		for(String wnds : allwnds)
		{
			System.out.println(wnds);
			d.switchTo().window(wnds);
			System.out.println(d.getTitle());
			if(!mainwnd.equals(wnds)){
			d.close();
		}
		}
		
		d.switchTo().window(mainwnd);
		System.out.println(d.getTitle());
		
		
		
		d.quit();		
				
	}

}
