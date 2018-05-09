/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaUsuario;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author Ramon Larivoir
 */
public class changePasswordTest {

    static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Ramon Larivoir/Desktop/Ramon/Programas/Selenium/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("disable-infobars");
        driver = (WebDriver) new ChromeDriver(options);

        driver.get("https://atlantis.isti.cnr.it:5000/");

        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("student1@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("Password123");
        email.submit();
        
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("settings-button")));
    }

    @Test
    public void acessaSettings() {
        WebElement settings = driver.findElement(By.id("settings-button"));
        settings.click();
    }
    
    @Test
    public void botaoChange() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button-small")));
        driver.findElement(By.className("button-small")).click();
    }
    
    @Test
    public void changePass() {
        WebElement currentPass = driver.findElement(By.name("inputCurrentPassword"));
        WebElement newPass = driver.findElement(By.name("inputNewPassword"));
        WebElement repeatNewPass = driver.findElement(By.name("inputNewPassword2"));
        
        currentPass.sendKeys("Password123");
        newPass.sendKeys("pass");
        repeatNewPass.sendKeys("pass");
        
        repeatNewPass.submit();
    }
    
    @Test
    public void validate(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"password-modal\"]/div/div/form/app-error-message/div/h5")));
        
        assertEquals(driver.findElement(By.tagName("h5")).getText(), "Password changed succesfully!");
    }
}
