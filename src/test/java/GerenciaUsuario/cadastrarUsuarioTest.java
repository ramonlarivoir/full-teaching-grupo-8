/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaUsuario;

import static GerenciaUsuario.changePasswordTest.driver;
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
public class cadastrarUsuarioTest {
    
    static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ramon Larivoir/Desktop/Ramon/Programas/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver(options);

        driver.get("https://atlantis.isti.cnr.it:5000/");
    }
    
    @Test
    public void novoUsuario() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signUpButton")));
        
        driver.findElement(By.id("signUpButton")).click();
        
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nickName")));
        WebElement email = driver.findElement(By.name("email"));
        WebElement nome = driver.findElement(By.name("nickName"));
        WebElement pass = driver.findElement(By.name("password"));
        WebElement confirmPass = driver.findElement(By.name("confirmPassword"));
        
        email.sendKeys("ramon@gmail.com");
        nome.sendKeys("Ramon");
        pass.sendKeys("Ramon123");
        confirmPass.sendKeys("Ramon123");
        
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[5]")).click();

    }
    
    @Test
    public void validate() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        
        driver.findElement(By.id("sign-up-btn")).click();
        
    }
}