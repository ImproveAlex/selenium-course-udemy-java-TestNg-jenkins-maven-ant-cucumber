package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class AutoSuggestedDropdown {
    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("It");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement puneElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@id='ui-id-1']/li/a"))
        );
        List <WebElement> countriesFoundAfterSearch = driver.findElements(By.xpath("//ul[@id='ui-id-1']/li"));
        for (WebElement country : countriesFoundAfterSearch){
            if (country.findElement(By.tagName("a")).getText().equals("Italy")){
                country.findElement(By.tagName("a")).click();
                break;
            }

        }
        List <WebElement> discountCheckboxes = driver.findElements(By.xpath("//div[@id='discount-checkbox']//input"));
        for (WebElement checkbox : discountCheckboxes){
            Assert.assertFalse(checkbox.isSelected());
            checkbox.click();
            Assert.assertTrue(checkbox.isSelected());
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.quit();
    }
}
