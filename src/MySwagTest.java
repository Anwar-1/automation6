import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MySwagTest {

	WebDriver driver = new ChromeDriver();
	String Excepted = "Products";
	String TheExpectedTheLowestPrice= "$7.99";
	
	
	@BeforeTest
	public void Setup() {
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
	}
	
	@Test(priority = 1)
	public void log_in() {
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
	}
	
	@Test(priority = 2)
	public void theProductIsFound() {
		String Acutual = driver.findElement(By.xpath("//span[@data-test='title']")).getText();	
		Assert.assertEquals(Acutual, Excepted);
	}
	
	@Test(priority = 3)
	public void theSortItem() throws InterruptedException {
		/*driver.findElement(By.xpath("//select[@data-test='product-sort-container']")).click();
		driver.findElement(By.xpath("//option[@value='lohi']")).click();
		this is true but the best answer is down
		*/
	WebElement selected = 	driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(selected);
		myselect.selectByValue("lohi");
		//myselect.selectByVisibleText("Price (low to high)");
		//Thread.sleep(3000);
		//driver.navigate().refresh();
		//myselect.selectByIndex(1);
		
	}
	
	@Test(priority = 4 )
	public void TheAcutalTheLowestPrice() {
	 
	 List<WebElement>   theprice    =	driver.findElements(By.className("inventory_item_price"));
	 
	for(int i = 0; i< theprice.size();i++) {
	String actual=	theprice.get(0).getText();
	
	Assert.assertEquals(actual, TheExpectedTheLowestPrice);
	 }
	
	}
	
	@Test(priority = 5)
	public void TheAcutalTheHighestPrice() {
		
		List<WebElement>  theprice  = driver.findElements(By.className("inventory_item_price"));
		 String Excptedhighest = "$49.99";
		String acutual =     theprice.get(theprice.size()-1).getText();
		Assert.assertEquals(acutual,Excptedhighest);
	}
	
	@Test(priority = 6)
	public void theNameAtoZ() throws InterruptedException {
		Thread.sleep(3000);
		WebElement selected = 	driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(selected);
		myselect.selectByVisibleText("Name (A to Z)");
		
		 List<WebElement>   thelaststring   =	driver.findElements(By.className("inventory_item_name"));
	String actual = thelaststring.get(thelaststring.size()-1).getText();
	String Excepted = "Test.allTheThings() T-Shirt (Red)";
	Assert.assertEquals(actual,Excepted);
	
	}
	
	@Test(priority = 6)
	public void theNameZtoA() throws InterruptedException {
		Thread.sleep(3000);
		WebElement selected = 	driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(selected);
		myselect.selectByValue("za");
		
		 List<WebElement>   thelaststring   =	driver.findElements(By.className("inventory_item_name"));
	String actual = thelaststring.get(thelaststring.size()-1).getText();
	String Excepted = "Sauce Labs Backpack";
	Assert.assertEquals(actual,Excepted);
	
	}
	
	@Test(priority = 7)
	public void thepricelowtohigh() throws InterruptedException {
		Thread.sleep(3000);
		WebElement selected = 	driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(selected);
		myselect.selectByValue("lohi");
		
		 List<WebElement>   thelaststring   =	driver.findElements(By.className("inventory_item_name"));
	String actual = thelaststring.get(thelaststring.size()-1).getText();
	String Excepted = "Sauce Labs Fleece Jacket";
	Assert.assertEquals(actual,Excepted);
	
	}
	
	
	@Test(priority = 8)
	public void thepricehightolow() throws InterruptedException {
		Thread.sleep(3000);
	WebElement price	=driver.findElement(By.xpath("//select[@data-test='product-sort-container']"));
		Select myselect = new Select(price);
		myselect.selectByVisibleText("Price (high to low)");
		
		       List<WebElement>  thelaststring  = driver.findElements(By.className("inventory_item_name"));
		       
		       String actual = thelaststring.get(thelaststring.size()-1).getText();
		       
		       String Excepted = "Sauce Labs Onesie";
		       
		       Assert.assertEquals(actual,Excepted);
	}
}
