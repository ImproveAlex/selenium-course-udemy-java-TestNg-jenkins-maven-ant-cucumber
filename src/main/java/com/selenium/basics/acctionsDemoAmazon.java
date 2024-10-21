package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class acctionsDemoAmazon {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.amazon.es/");
        //sp-cc-accept
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement rejectCookiesButton = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.id("sp-cc-rejectall-link"))
        );
        rejectCookiesButton.click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("POKEMON").doubleClick().build().perform();
        driver.quit();
        //action.moveToElement(driver.findElement(By.id("nav-link-accountList"))).contextClick().build().perform();

    }
}
