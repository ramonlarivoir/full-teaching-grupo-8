package GerenciarForum;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Publicacao {

    static WebDriver driver;


    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomAlphaNumeric(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver(options);

        driver.get("https://atlantis.isti.cnr.it:5000/");
    }

    public void loga() throws InterruptedException {
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("teacher@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();

        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);

        assertEquals("SETTINGS", driver.findElement(By.id("settings-button")).getText());
    }

    @Test
    public void testCreate() throws InterruptedException {
        loga();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.cssSelector("span.cal-day-badge")));

        WebElement badge = driver.findElement(By.cssSelector("span.cal-day-badge"));
        badge.click();

        WebElement forward = driver.findElement(By.cssSelector("i.material-icons.calendar-event-icon"));
        forward.click();

        wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("forum-tab-icon")));

        WebElement forum = driver.findElement(By.cssSelector("i#forum-tab-icon.material-icons.tooltipped"));
        forum.click();

        WebElement newEntry = driver.findElement(By.cssSelector("i#add-entry-icon.material-icons.forum-icon"));
        newEntry.click();

        String entry_title = Publicacao.randomAlphaNumeric(10);
        WebElement title = driver.findElement(By.id("input-post-title"));
        title.sendKeys(entry_title);

        WebElement comment = driver.findElement(By.id("input-post-comment"));
        comment.sendKeys("Comment on entry");

        WebElement send = driver.findElement(By.id("post-modal-btn"));
        send.click();

        assertEquals(entry_title, driver.findElement(By.cssSelector("a.forum-entry-title")).getText());

        driver.close();
    }

    @Test
    public void testOpen() throws InterruptedException {
        loga();

        WebElement badge = driver.findElement(By.cssSelector("span.cal-day-badge"));
        badge.click();

        WebElement forward = driver.findElement(By.cssSelector("i.material-icons.calendar-event-icon"));
        forward.click();

        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };

        Thread.sleep(1000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(expectation);
        wait.until(visibilityOfElementLocated(By.id("forum-tab-icon")));

        WebElement forum = driver.findElement(By.cssSelector("i#forum-tab-icon.material-icons.tooltipped"));
        forum.click();

        WebElement publicacao = driver.findElement(By.cssSelector("a.forum-entry-title"));
        publicacao.click();

        wait = new WebDriverWait(driver, 30);
        wait.until(visibilityOfElementLocated(By.id("row-of-comments")));

        visibilityOfElementLocated(By.cssSelector("i.material-icons.forum-icon"));

        driver.close();
    }
}
