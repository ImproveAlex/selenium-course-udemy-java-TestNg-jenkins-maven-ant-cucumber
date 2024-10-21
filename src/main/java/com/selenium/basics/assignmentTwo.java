package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class assignmentTwo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys("Alejandro");
        driver.findElement(By.name("email")).sendKeys("Alex@email.com");
        driver.findElement(By.xpath("//input[@placeholder= 'Password']")).sendKeys("12345");
        driver.findElement(By.id("exampleCheck1")).click();
        WebElement staticDropdownGender = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdownGender = new Select(staticDropdownGender);
        dropdownGender.selectByIndex(0);
        driver.findElement(By.cssSelector("#inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("02-26-2000");
        driver.findElement(By.className("btn-success")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successMsgBox = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success alert-dismissible']"))
        );
        Assert.assertTrue(successMsgBox.findElement(By.tagName("strong")).getText().equals("Success!"));
        System.out.println(successMsgBox.findElement(By.tagName("strong")).getText());
        driver.quit();
    }
}
