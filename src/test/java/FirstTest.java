import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() throws InterruptedException {
        //инициализация драйвера
        driver = new ChromeDriver();
        //новый механизм установки неявных ожиданий (selenium>4.0)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //устанавливаем размер окна браузера
        driver.manage().window().setSize(new Dimension(900,800));
    }

    @Test
    public void myFirstTest() throws InterruptedException {
        //открываем страницу
        driver.get("https://www.google.com/");
        //Берем экранную клавиатуру и используем набор
        driver.findElement(By.className("Umvnrc")).click();
        driver.findElement(By.id("K222")).click();
        driver.findElement(By.id("K78")).click();
        driver.findElement(By.id("K74")).click();
        driver.findElement(By.id("K32")).click();
        driver.findElement(By.className("Umvnrc")).click();
        driver.findElement(By.name("q")).sendKeys("webdriver");
        driver.findElement(By.name("btnK")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
