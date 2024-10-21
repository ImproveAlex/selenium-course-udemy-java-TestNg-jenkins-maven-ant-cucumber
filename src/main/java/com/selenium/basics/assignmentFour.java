package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class assignmentFour {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[normalize-space()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Click Here']")).click();

        // Get all window handles and convert to a List
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Switch to the last tab (latest window)
        driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.switchTo().window(windowHandles.get(0));
        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
}
