package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Locators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("ImproveAlex");
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("12345");
        driver.findElement(By.name("chkboxOne")).click();
        driver.findElement(By.cssSelector("input[value='agreeTerms']")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement incorrectUserNameMsg = driver.findElement(By.xpath("//p[@class = 'error' and text()='* Incorrect username or password']"));
        wait.until(d -> incorrectUserNameMsg.isDisplayed());
        assert incorrectUserNameMsg.getText().equals("* Incorrect username or password");
        driver.findElement(By.xpath("//a[@href = '#' and text()='Forgot your password?']")).click();
        WebElement forgotPasswordTitle = driver.findElement(By.xpath(" //h2[normalize-space()='Forgot password']"));
        wait.until(d -> forgotPasswordTitle.isDisplayed());
        List<WebElement> formInputElements = driver.findElements(By.xpath("//form[h2[text()='Forgot password']]//input"));
        String[] inputValues = {
                "Alejandro",
                "alex@example.com",
                "3467557326"
        };

        for (int i = 0; i < formInputElements.size() && i < inputValues.length; i++) {
            formInputElements.get(i).sendKeys(inputValues[i]); // Send the value to the input field
        }
        driver.findElement(By.className("reset-pwd-btn")).click();
        WebElement temporaryPassword = driver.findElement(By.className("infoMsg"));
        wait.until(d -> temporaryPassword.isDisplayed());
        String temporaryPasswordText = temporaryPassword.getText();
        String otpPassword = extractPassword(temporaryPasswordText);
        System.out.println(otpPassword);
        driver.findElement(By.className("go-to-login-btn")).click();
        driver.findElement(By.id("inputUsername")).clear();
        driver.findElement(By.id("inputUsername")).sendKeys("ImproveAlex");
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).clear();
        driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys(otpPassword);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        String successMsg = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        System.out.println(successMsg);
        assertTrue(successMsg.contains("Improve"));
        System.out.println(successMsg);
        try {
            Thread.sleep(5000); // Sleep for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();// Handle the exception, for example, by printing the stack trace
        }
        driver.quit();
    }
    public static String extractPassword(String input) {
        // Find the first and second single quotes
        int startIndex = input.indexOf("'") + 1; // Position after the first single quote
        int endIndex = input.indexOf("'", startIndex); // Position before the second single quote

        // Extract the text between the single quotes
        return input.substring(startIndex, endIndex);
    }
}
