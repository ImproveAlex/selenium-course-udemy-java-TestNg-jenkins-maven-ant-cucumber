import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SelIntroduction {

    public static void main(String[] args) {
        // Create a list of browsers
        List<String> browsers = new ArrayList<>();
        browsers.add("chrome");
        browsers.add("firefox");
        browsers.add("edge");
        browsers.add("internet explorer");

        // Iterate through the browsers
        for (String browser : browsers) {
            System.out.println("Running test on: " + browser);
            runTest(browser);
        }
    }

    public static void runTest(String browser) {
        WebDriver driver = null;

        // Set up WebDriver for each browser
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "internet explorer":
                driver = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Browser not supported: " + browser);
                return;
        }

        // Execute the test
        try {
            // Navigate to Google
            driver.get("https://www.google.com");

            // Click on "Rechazar todo" button (assuming it appears on the page)
            driver.findElement(By.xpath("//div[contains(@class, 'QS5gu') and text()='Rechazar todo']")).click();

            // Locate the search input field by ID and wait until it's visible
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("APjFqb")));

            // Send text to the input field and press Enter
            searchBox.sendKeys("Lol Esports");
            searchBox.sendKeys(Keys.RETURN);

            // Wait for the results to load
            wait.until(ExpectedConditions.titleContains("Lol Esports"));

            // Optional: Wait for a while to observe the result
            Thread.sleep(5000); // Wait for 5 seconds

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}

