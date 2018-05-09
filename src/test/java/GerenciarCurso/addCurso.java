/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciarCurso;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author Ramon Larivoir
 */
public class addCurso {

    static WebDriver driver;
    
    @BeforeClass
    public static void configura() {
        System.setProperty("webdriver.chrome.driver", "/home/douglas/Downloads/chromedriver");
        driver = (WebDriver) new ChromeDriver();

        driver.get("https://atlantis.isti.cnr.it:5000/");

    }

    @Test
    public void addCourse() {
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("teacher@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("pass");
        email.submit();
        WebElement addcourse = driver.findElement(By.id("submit-post-course"));
        addcourse.click();
        WebElement nome = driver.findElement(By.id("input-post-course-name"));
        nome.sendKeys("Computação");
        nome.submit();
    }
}