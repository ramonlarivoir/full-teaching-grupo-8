/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Ramon Larivoir
 */
public class LoginTest {

    static WebDriver driver;

    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "/home/douglas/Downloads/chromedriver");
        driver = (WebDriver) new ChromeDriver();

        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

//
//    @Test
//    public void testaLogin() {
//        WebElement login = driver.findElement(By.id("download-button"));
//        login.click();
//        WebElement email = driver.findElement(By.name("email"));
//        email.sendKeys("teacher@gmail.com");
//        WebElement senha = driver.findElement(By.name("password"));
//        senha.sendKeys("pass");
//        email.submit();
//    }
//
//    @Test
//    public void addCourse() {
//        WebElement login = driver.findElement(By.id("download-button"));
//        login.click();
//        WebElement email = driver.findElement(By.name("email"));
//        email.sendKeys("teacher@gmail.com");
//        WebElement senha = driver.findElement(By.name("password"));
//        senha.sendKeys("pass");
//        email.submit();
//        WebElement addcourse = driver.findElement(By.id("submit-post-course"));
//        addcourse.click();
//        WebElement nome = driver.findElement(By.id("input-post-course-name"));
//        nome.sendKeys("Computação");
//        nome.submit();
//    }
//
//    @Test
//    public void goToSettings() {
//        WebElement login = driver.findElement(By.id("download-button"));
//        login.click();
//        WebElement email = driver.findElement(By.name("email"));
//        email.sendKeys("nickzation@gmail.com");
//        WebElement senha = driver.findElement(By.name("password"));
//        senha.sendKeys("Mm99454391");
//        email.submit();
//        WebElement configuracoes = driver.findElement(By.id("settings-button"));
//        configuracoes.click();
//    }


    @Test
    public void goToDropDown() {
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("nickzation@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("Mm99454391");
        email.submit();

        driver.switchTo().window("https://atlantis.isti.cnr.it:5000/courses");
        WebElement configuracoes = driver.findElement(By.id("arrow-drop-down"));
        configuracoes.click();
    }
 
}
