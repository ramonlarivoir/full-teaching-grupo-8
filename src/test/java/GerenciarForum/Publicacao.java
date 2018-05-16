package GerenciarForum;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Publicacao {

    static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver(options);

        driver.get("https://atlantis.isti.cnr.it:5000/");
    }

    public void loga() {
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("student1@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("settings-button")));

        assertEquals("SETTINGS", driver.findElement(By.id("settings-button")).getText());
    }

    @Test
    public void testCreate() {
        loga();
        driver.close();
    }
}
