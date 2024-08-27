import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class myTestCase {

	String URL= "https://www.google.com/";
	String Excepted = "Google";
	WebDriver driver = new ChromeDriver();
	
	@Test(description = "the first test",invocationCount = 3)
	public void verfiythatgoogleistitle() {
		driver.get(URL);
		
		//String TheAcutual = driver.findElement(By.tagName("title")).getText(); wrong
		String TheAcutual = driver.getTitle();
		
		Assert.assertEquals(TheAcutual,Excepted);
	}
}
