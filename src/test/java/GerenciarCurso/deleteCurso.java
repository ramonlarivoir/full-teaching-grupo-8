/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarCurso;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ramon Larivoir
 */
public class deleteCurso {

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

    }

    @Test
    public void deleteCourse() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"course-list\"]/li[3]/div/div[3]/a/i")));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"course-list\"]/li[3]/div/div[3]/a/i")).click();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("label#label-delete-checkbox")).click();
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a#delete-course-btn")));
        driver.findElement(By.cssSelector("a#delete-course-btn")).click();
        
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
        assertFalse(driver.getPageSource().contains("Computação"));
        
        driver.close();
    }
}
