package tc05;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class TC05 {
	public static WebDriver driver;
	@Given("User is on Home Page")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Farid\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe"); 
		driver.navigate().to("https://agoda.com/");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		}

	@When("User Searches for a hotel")
	public void user_searches_for_a_hotel() throws Throwable {
		Actions actions = new Actions(driver);
		//Wait for Ad
		Thread.sleep(8000);
		//Close Ad
		actions.moveToElement(driver.findElement(By.className("ab-close-button"))).click().build().perform();
		//Search for a hotel in Tokyo
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).sendKeys("Tokyo");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"tab-all-rooms-tab\"]/div"))).click().build().perform();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,10000)");
		Thread.sleep(3000);
		//Click on search
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/button"))).click().build().perform();
		//wait for search results
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3000)");
		//Check 4-Stars checkmark
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SideBarLocationFilters\"]/div[6]/div[2]/ul/li[2]/span"))).click().build().perform();
		Thread.sleep(8000);
		js.executeScript("window.scrollBy(0,-3000)");
		
		}

	@Then("Four-star hotels displayed successfully")
	public void fourstar_hotel_displayed_successfully() throws Throwable {
		if( driver.findElement(By.cssSelector(".gWCdaf")).isDisplayed())
		{
			System.out.println("Four-star hotel succesfully detected in first search result");
			System.out.println("Four-star hotel filtering success");
		}
		else
		{
			System.out.println("Could not detect four-star hotel in first search result");
			System.out.println("Failed to display four-star hotels");
		}
	}

}
