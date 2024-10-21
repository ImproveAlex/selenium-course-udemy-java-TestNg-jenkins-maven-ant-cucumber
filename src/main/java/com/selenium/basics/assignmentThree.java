package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class assignmentThree {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement okayButtonUserLogin = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.id("okayBtn"))
        );
        okayButtonUserLogin.click();
        WebElement staticDropdownUserType = driver.findElement(By.xpath("//select[@data-style = 'btn-info']"));
        Select dropdownGender = new Select(staticDropdownUserType);
        dropdownGender.selectByIndex(2);
        driver.findElement(By.id("terms")).click();
        String initialUrl = driver.getCurrentUrl();
        driver.findElement(By.id("signInBtn")).click();
        explicitWait.until(driver1 -> !driver.getCurrentUrl().equals(initialUrl));
        Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/angularpractice/shop");
        List<WebElement> phoneCards = driver.findElements(By.xpath("//app-card-list/*"));
        System.out.println(phoneCards.size());
        for (WebElement phone : phoneCards){
            phone.findElement(By.xpath("//button[@class='btn btn-info']")).click();
        }
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.quit();
    }
}
