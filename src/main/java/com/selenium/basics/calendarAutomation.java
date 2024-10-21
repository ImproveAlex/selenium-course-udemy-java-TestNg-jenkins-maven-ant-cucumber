package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class calendarAutomation {
    public static void main(String[] args) {
        int day = 6, year = 2027;
        String month = "May";

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.className("react-date-picker__calendar-button")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        List<WebElement> years = driver.findElements(By.xpath("//div[@class='react-calendar__decade-view__years']/*"));
        for (WebElement myYear : years){
            if (myYear.getText().contains(String.valueOf(year))){
                myYear.click();
                break;
            }
        }
        List<WebElement> months = driver.findElements(By.xpath("//div[@class='react-calendar__year-view__months']/*"));
        for (WebElement myMonth : months){
            if (myMonth.getText().contains(month)){
                myMonth.click();
                break;
            }
        }
        List<WebElement> days = driver.findElements(By.xpath("//div[@class='react-calendar__month-view__days']/*"));
        int daysCount = 0;
        WebElement myRealDay = null;
        for (WebElement myDay : days){
            if (myDay.getText().equals(String.valueOf(day))){
                daysCount++;
                myRealDay = myDay;
            }
            if (daysCount == 2){
                myDay.click();
                break;
            }
        }
        if (daysCount ==1){
            myRealDay.click();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.quit();
    }
}
