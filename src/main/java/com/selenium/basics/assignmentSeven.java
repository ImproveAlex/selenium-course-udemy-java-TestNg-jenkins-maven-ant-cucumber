package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class assignmentSeven {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> webTableExample = driver.findElements(By.xpath("(//table[@id='product' and @name='courses'])/tbody/*"));
        System.out.println(webTableExample.size());
        List<WebElement> columns = webTableExample.getFirst().findElements(By.tagName("th"));
        System.out.println(columns.size());
        List<WebElement> secondRow = webTableExample.get(1).findElements(By.tagName("td"));
        for (WebElement col : secondRow){
            System.out.println(col.getText());
        }
        driver.quit();
    }
}
