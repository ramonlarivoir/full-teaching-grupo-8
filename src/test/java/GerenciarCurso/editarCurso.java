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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ramon Larivoir
 */
public class editarCurso {

    static WebDriver driver;
    
    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.gecko.driver", "/ice/Downloads/geckodriver");        
        driver = (WebDriver) new FirefoxDriver();
        driver.get("https://atlantis.isti.cnr.it:5000/");
        
        
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("teacher@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[3]/a")));

    }

    @Test
    public void editarCurso() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[3]/a")));
        driver.findElement(By.xpath("/html/body/app/div/main/app-dashboard/div/div[3]/div/div[1]/ul/li[1]/div/div[3]/a")).click();
        
        
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"input-put-course-name\"]")));
        WebElement nome = driver.findElement(By.id("input-put-course-name"));
        //WebElement nome = driver.findElement(By.xpath("//*[@id=\"input-post-course-name\"]"));
        
        //nome.clear();        
        nome.sendKeys("aaaaaa");
        //nomys("aaaaaa");e.sendKeys(Keys.TAB);
        nome.submit();                
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
        assertTrue(driver.getPageSource().contains("aaaaaa"));
        
        driver.close();
    }

}
