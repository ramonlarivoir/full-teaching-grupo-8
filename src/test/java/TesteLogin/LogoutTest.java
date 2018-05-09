/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesteLogin;

import static TesteLogin.LoginTest.driver;
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
public class LogoutTest {
    
    static WebDriver driver;
    
    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ramon Larivoir/Desktop/Ramon/Programas/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver();
        
        
        driver.get("https://atlantis.isti.cnr.it:5000/");
        
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("student1@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();
        
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("arrow-drop-down")));
    }
    
    @Test
    public void testaLogout() {
        driver.findElement(By.id("arrow-drop-down")).click();
        driver.findElement(By.id("logout-button")).click();
    }
}
