package com.selenium.basics;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class assignmentSix {
    public static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(3); // Generates a number between 1 and 3
    }


    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> optionCheckboxElement = driver.findElements(By.xpath("//div[@id='checkbox-example']//label"));
        int randomNumberOption = getRandomNumber();
        optionCheckboxElement.get(randomNumberOption).findElement(By.tagName("input")).click();
        String optionText = optionCheckboxElement.get(randomNumberOption).getText();
        WebElement staticDropdownOptions = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdownOptions);
        dropdown.selectByValue(optionText.toLowerCase());
        driver.findElement(By.id("name")).sendKeys(optionText);
        driver.findElement(By.id("alertbtn")).click();
        Alert alert = driver.switchTo().alert();
        // Get the text of the alert
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains(optionText));
        System.out.println("Success");
        driver.quit();
    }
}
