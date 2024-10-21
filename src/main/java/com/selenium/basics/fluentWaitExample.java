package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class fluentWaitExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.freecodecamp.org/learn/");
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement searchBar = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search 11,300+ tutorials']"))
        );
        searchBar.sendKeys("pytorch");
        Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);

        WebElement pyTorchVSTensorFlowArticle = fluentWait.until(driver1 -> driver.findElement(By.xpath("//li[@data-fccobjectid ='66d0361612c679876b0602e9']")));
        pyTorchVSTensorFlowArticle.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.quit();
    }
}
