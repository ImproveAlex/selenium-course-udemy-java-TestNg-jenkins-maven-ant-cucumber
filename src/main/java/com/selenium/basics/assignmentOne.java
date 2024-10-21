package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;

public class assignmentOne {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement optionOneChcekbox = driver.findElement(By.id("checkBoxOption1"));
        optionOneChcekbox.click();
        Assert.assertTrue(optionOneChcekbox.isSelected());
        optionOneChcekbox.click();
        Assert.assertFalse(optionOneChcekbox.isSelected());
        List<WebElement> optionCheckboxes = driver.findElements(By.xpath("//div[@id='checkbox-example']//input"));
        Assert.assertEquals(optionCheckboxes.size(), 3);
        driver.quit();

    }
}
