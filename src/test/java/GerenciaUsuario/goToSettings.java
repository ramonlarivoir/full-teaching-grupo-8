/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GerenciaUsuario;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *
 * @author Ramon Larivoir
 */
public class goToSettings {

    static WebDriver driver;

    @Test
    public void goToSettings() {
        WebElement login = driver.findElement(By.id("download-button"));
        login.click();
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("nickzation@gmail.com");
        WebElement senha = driver.findElement(By.name("password"));
        senha.sendKeys("Mm99454391");
        email.submit();
        WebElement configuracoes = driver.findElement(By.id("settings-button"));
        configuracoes.click();
    }
}
