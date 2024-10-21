package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class assignmentFive {
        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
            driver.findElement(By.xpath("//a[normalize-space()='Nested Frames']")).click();
            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
            driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
            System.out.println(driver.findElement(By.id("content")).getText());
            driver.quit();
        }
}

