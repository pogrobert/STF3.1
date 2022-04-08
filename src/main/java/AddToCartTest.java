import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;

import static org.testng.Assert.assertEquals;


public class AddToCartTest {
    WebDriver driver;
    String ebayURL = "https://www.ebay.com";
    By searchbarPath = By.name("_nkw");
    By searchButtonPath = By.id("gh-btn");
    By itemsFirstElementPath = By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[1]/div/a");
    By addToCartBtnPath = By.id("isCartBtn_btn");

    @Test
    public void TestAddToCart() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();

        driver.get(ebayURL);
        driver.findElement(searchbarPath).sendKeys("book");
        driver.findElement(searchButtonPath).click();
        driver.findElement(itemsFirstElementPath).click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        driver.findElement(addToCartBtnPath).click();

        assertEquals(driver.getCurrentUrl(), "https://cart.payments.ebay.com/");

        driver.quit();
    }
}
