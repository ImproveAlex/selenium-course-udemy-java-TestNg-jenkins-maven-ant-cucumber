package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dropdowns {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown1 = new Select(staticDropdown);
        dropdown1.selectByIndex(0);
        System.out.println(dropdown1.getFirstSelectedOption().getText());
        dropdown1.selectByVisibleText("USD");
        System.out.println(dropdown1.getFirstSelectedOption().getText());
        dropdown1.selectByValue("INR");
        System.out.println(dropdown1.getFirstSelectedOption().getText());
        driver.findElement(By.id("divpaxinfo")).click();
        //Add there adults
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        driver.findElement(By.id("divpaxinfo")).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        String numAddultsAdded = driver.findElement(By.id("spanAudlt")).getText();
        System.out.println(numAddultsAdded);
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement puneElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@value='PNQ']"))
        );
        puneElement.click();
        WebElement mumbaiElement = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@value='BOM'])[2]"))
        );
        mumbaiElement.click();
        WebElement departDate = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table/tbody//a[text()='31']"))
        );
        departDate.click();
        driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
        WebElement returnDate = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='ui-datepicker-div']/div[2]/table/tbody//a[text()='3']"))
        );

        returnDate.click();

        // Click the button
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
        // Wait for the page to fully reload by checking when the document state is 'complete'
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> "complete".equals(((JavascriptExecutor) webDriver).executeScript("return document.readyState"))
        );

        System.out.println("Page has been refreshed.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.quit();
    }


}
