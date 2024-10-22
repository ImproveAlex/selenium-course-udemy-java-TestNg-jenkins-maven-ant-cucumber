package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class brokenLinks {
    public static void main(String[] args){
        ChromeOptions myChromeOptions = new ChromeOptions();
        myChromeOptions.setAcceptInsecureCerts(true);
        WebDriver driver = new ChromeDriver(myChromeOptions);

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("a")));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String url = link.getAttribute("href");
            if (url != null && !url.isEmpty()) { // Make sure the URL is not null or empty
                checkLink(url);
            }
        }
        driver.quit();
    }
    private static void checkLink(String linkUrl) {
        try {
            // Create a URL object
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("HEAD");
            httpURLConnection.connect();

            // Get the response code
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                System.out.println(linkUrl + " - is working.");
            } else {
                System.out.println(linkUrl + " - is not working. Response code: " + responseCode);
            }
        } catch (ProtocolException e) {
            throw new RuntimeException(e);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
