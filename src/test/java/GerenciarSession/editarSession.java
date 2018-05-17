/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarSession;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ramon Larivoir
 */
public class editarSession {

    static WebDriver driver;

    @BeforeClass
    public static void configura() {
//        System.setProperty("webdriver.chrome.driver", "/home/douglas/Downloads/chromedriver");
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ramon Larivoir/Desktop/Ramon/Programas/Selenium/chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver", "C:/Users/Ramon Larivoir/Desktop/Ramon/Programas/Selenium/geckodriver.exe");
        ChromeOptions options = new ChromeOptions();
//        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver(options);
//        driver = (WebDriver) new FirefoxDriver(options);

        driver.get("https://atlantis.isti.cnr.it:5000/");

        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("teacher@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-course-icon\"]")));

        driver.findElement(By.xpath("//*[@id=\"add-course-icon\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-post-course-name\"]")));
        WebElement nome = driver.findElement(By.xpath("//*[@id=\"input-post-course-name\"]"));
        nome.sendKeys("Computação");
        nome.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course-list\"]/li[2]/div/div[2]")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.findElement(By.id("inputPostCourseImage")).click();
        driver.findElement(By.xpath("//*[@id=\"course-list\"]/li[2]/div/div[2]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sessions-tab-icon")));
        driver.findElement(By.id("sessions-tab-icon")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"add-session-icon\"]")));
        driver.findElement(By.xpath("//*[@id=\"add-session-icon\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-post-title\"]")));
        WebElement title = driver.findElement(By.xpath("//*[@id=\"input-post-title\"]"));
        title.sendKeys("titulo");

        WebElement descricao = driver.findElement(By.xpath("//*[@id=\"input-post-comment\"]"));
        descricao.sendKeys("descricao");

        WebElement data = driver.findElement(By.xpath("//*[@id=\"input-post-date\"]"));
        data.sendKeys("11052018");

        WebElement time = driver.findElement(By.xpath("//*[@id=\"input-post-time\"]"));
        time.sendKeys("1111");
        time.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void editarSession() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("courses-button")));
        driver.findElement(By.id("courses-button")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-put-title")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement titulo = driver.findElement(By.id("input-put-title"));
        WebElement descricao = driver.findElement(By.id("input-put-comment"));
        WebElement date = driver.findElement(By.id("input-put-date"));
        WebElement time = driver.findElement(By.id("input-put-time"));
        
        titulo.sendKeys("titulo2");
        descricao.sendKeys("descricao2");
        date.sendKeys("16052018");
        time.sendKeys("2222");
        time.submit();
        
        driver.close();
        
        
    }
}
