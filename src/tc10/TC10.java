package tc10;
import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class TC10 {
	public static WebDriver driver;
	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Farid\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://agoda.com/");
		}

	@When("^User Searches for a hotel$")
	public void user_searches_for_a_hotel() throws Throwable {
		Thread.sleep(8000);
	  	Actions actions = new Actions(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions.moveToElement(driver.findElement(By.className("ab-close-button"))).click().build().perform();
		//search for hotel 1
		driver.findElement(By.xpath("//*[@id=\"tab-home\"]/div")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"textInput\"]")).sendKeys("Tokyo");
		Thread.sleep(2000);
		//search for hotel 2
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,10000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-10000)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[3]/div/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"autocomplete-box\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"autocomplete-box\"]")).sendKeys("Tokyo");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,10000)");
		Thread.sleep(3000);
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"SearchBoxContainer\"]/div[1]/div/div[2]/div/div/button"))).click().build().perform();
		//wait for search results
		Thread.sleep(5000);
		//click first result 1
		js.executeScript("window.scrollBy(0,350)");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"contentContainer\"]/div[3]/ol/li[1]/div/a"))).click().build().perform();
		//switch to new tab
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tabs.size()-1));
		Thread.sleep(5000);
		//scroll to room
		js.executeScript("window.scrollBy(0,2000)");
		//reserve
		actions.moveToElement(driver.findElement(By.cssSelector(".ChildRoomsList-bookButtonInput"))).click().build().perform();
		Thread.sleep(5000);
		//click first result 2
		js.executeScript("window.scrollBy(0,350)");
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"contentContainer\"]/div[2]/ol/li[2]/div/a"))).click().build().perform();
		//switch to new tab
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(tabs2.size()-1));
		Thread.sleep(5000);
		//scroll to room
		js.executeScript("window.scrollBy(0,2000)");
		//reserve
		actions.moveToElement(driver.findElement(By.cssSelector(".ChildRoomsList-bookButtonInput"))).click().build().perform();
		Thread.sleep(5000);
		}

	@Then("^Reservation of Two Hotels displayed sucessfully$")
	public void reservation_of_two_hotels_displayed_successfully() throws Throwable {
		//check reservation page
		if(driver.findElement(By.xpath("//*[@id=\"agoda-spa\"]/main/div[1]/div/div[2]")).isDisplayed()) {
			
			System.out.println("Two hotels have been commenced for reservation");
			System.out.println("Two-hotel reservation successful");
		}
		else {
			System.out.println("Two-hotel reservation failed");
		}
		
	}

}
