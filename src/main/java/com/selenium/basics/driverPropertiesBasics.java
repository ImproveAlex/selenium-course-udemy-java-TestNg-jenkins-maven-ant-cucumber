package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class driverPropertiesBasics {
    public static void main(String[] args){
        ChromeOptions myChromeOptions = new ChromeOptions();
        boolean acceptInsecureCerts = true;
        String targetRepo = "selenium-course-udemy-java-TestNg-jenkins-maven-ant-cucumber";
        String downloadFilepath = "C:\\Users\\agonzanu\\Documents\\personal_courses\\selenium-course-udemy-java-TestNg-jenkins-maven-ant-cucumber";

        myChromeOptions.addArguments("disable-features=DownloadBubble,DownloadBubbleV2");
        myChromeOptions.setAcceptInsecureCerts(acceptInsecureCerts);
        Proxy myProxy = new Proxy();
        myProxy.setHttpProxy("ipaddress:4444");
        myChromeOptions.setCapability("proxy", myProxy);
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFilepath);
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.prompt_for_download", false);
        prefs.put("safebrowsing.enabled", true);
        prefs.put("safebrowsing.disable_download_protection", true);

        myChromeOptions.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(myChromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://github.com/improvealex");
        driver.findElement(By.xpath("(//nav[@aria-label='User profile'])[1]/a[@data-tab-item = 'repositories']")).click();
        explicitWait.until(ExpectedConditions.urlContains("tab=repositories"));
        List<WebElement> repoCards = driver.findElements(By.xpath("(//ul[@data-filterable-for = 'your-repos-filter'])/*"));
        for (WebElement repoCard : repoCards){
            String repoName = repoCard.findElement(By.tagName("h3")).getText().split(" Public")[0].trim();
            System.out.println(repoName);
            if (repoName.equals(targetRepo)) {
                repoCard.findElement(By.tagName("a")).click();
            }
        }
        explicitWait.until(ExpectedConditions.urlContains(targetRepo));
        WebElement codeButton = explicitWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(":R55ab:"))));
        codeButton.click();
        WebElement downloadZipButton = explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//ul[@class='List__ListBox-sc-1x7olzq-0 gtejMS'])/li[2]/a")));
        downloadZipButton.click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            driver.quit();
        }
        driver.quit();
    }

}
