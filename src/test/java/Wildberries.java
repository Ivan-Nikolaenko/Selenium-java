import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wildberries {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().setSize(new Dimension(1100, 1100));
    }

    @Test
    public void myFirstTest() {
        driver.get("https://www.wildberries.ru/");
        driver.findElement(By.cssSelector("#searchInput")).click();
        driver.findElement(By.cssSelector("#searchInput")).sendKeys("кроссовки мужские", Keys.ENTER);
        driver.findElement(By.cssSelector("[data-value='104']")).click();
        driver.findElement(By.cssSelector("[data-value='20624']")).click();
        driver.findElement(By.cssSelector("[data-value='561922']")).click();
        if (driver.getPageSource().contains("По запросу «кроссовки мужские» найдено"))
            System.out.println("Text is present in the page");
        else
            System.err.println("Text is not present in the page");

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
