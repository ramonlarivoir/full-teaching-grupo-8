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
        email.sendKeys("teacher@gmail.com");
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

        WebElement badge = driver.findElement(By.cssSelector("span.cal-day-badge"));
        badge.click();

        WebElement forward = driver.findElement(By.cssSelector("i.material-icons.calendar-event-icon"));
        forward.click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("forum-tab-icon")));

        WebElement forum = driver.findElement(By.cssSelector("i#forum-tab-icon.material-icons.tooltipped"));
        forum.click();

        WebElement newEntry = driver.findElement(By.cssSelector("i#add-entry-icon.material-icons.forum-icon"));
        newEntry.click();

        WebElement title = driver.findElement(By.cssSelector("input#input-post-title.validate.ng-pristine.ng-invalid.ng-touched"));
        title.sendKeys("New entry");

        WebElement comment = driver.findElement(By.cssSelector("textarea#input-post-comment.materialize-textarea.validate.ng-pristine.ng-invalid.ng-touched"));
        comment.sendKeys("Comment on entry");

        WebElement send = driver.findElement(By.cssSelector("button#post-modal-btn.waves-effect.btn-flat.modal-footer-button"));
        send.click();

        driver.close();
    }
}
