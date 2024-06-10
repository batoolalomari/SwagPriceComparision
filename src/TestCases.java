import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCases {

	String userName = "standard_user";
	String password = "secret_sauce";
	String url = "https://www.saucedemo.com/";

	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void Setup() {
		driver.manage().window().maximize();
		driver.get(url);

	}

	@Test(priority = 1)
	public void Login() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.id("user-name")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();

	}

	@Test(priority = 2)
	public void addItemsWithPriceLessThan15() throws InterruptedException {

		List<WebElement> prices = driver.findElements(By.className("inventory_item_price"));
		List<WebElement> addButtons = driver.findElements(By.className("btn_inventory"));

		List<Double> pricesAsNumber = new ArrayList<Double>();

		for (int i = 0; i < prices.size(); i++) {
			pricesAsNumber.add((Double.parseDouble(prices.get(i).getText().replace("$", ""))));
		}

		for (int j = 0; j < pricesAsNumber.size(); j++) {
			if (pricesAsNumber.get(j) > 15) {
				addButtons.get(j).click();

			}

		}

	}

}
