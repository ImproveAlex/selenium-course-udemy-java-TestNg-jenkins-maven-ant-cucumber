package com.selenium.basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class arrayListAutomation {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        driver.findElement(By.xpath("//input[@placeholder='Search for Vegetables and Fruits']")).sendKeys("c");
        // Initial list of products
        List<WebElement> products = driver.findElements(By.xpath("//div[@class='products']/div"));
        // Set up an explicit wait
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String productsToBuy[] = {"Brocolli","Carrot", "Corn", "Cashews"};
        // Wait until the size of products changes
        List<WebElement> finalProducts = products;
        explicitWait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                // Fetch the current size of the products
                List<WebElement> currentChildren = driver.findElements(By.xpath("//div[@class='products']/div"));
                // Return true if the size has changed
                return currentChildren.size() != finalProducts.size();
            }
        });

        // Update products to reflect the latest state after the wait
        products = driver.findElements(By.xpath("//div[@class='products']/div"));

        for(WebElement product : products){
            String productText = product.findElement(By.tagName("h4")).getText();
            productText = productText.split(" ")[0];
            if (Arrays.asList(productsToBuy).contains(productText)) {
                System.out.println(productText);
                product.findElement(By.tagName("button")).click();

            }
        }
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        WebElement checkoutCart = explicitWait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='PROCEED TO CHECKOUT']"))
        );
        String initialUrl = driver.getCurrentUrl();
        checkoutCart.click();
        // Alternatively, wait until the URL changes from the current URL
        explicitWait.until(driver1 -> !driver.getCurrentUrl().equals(initialUrl));
        driver.findElement(By.cssSelector("//input[@placeholder='Enter promo code']")).sendKeys("rahulshettyacademy");
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".promoInfo")));
        String seccondlUrl = driver.getCurrentUrl();
        driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
        explicitWait.until(driver1 -> !driver.getCurrentUrl().equals(seccondlUrl));
        WebElement staticDropdownCountries = driver.findElement(By.xpath("//div[@class='wrapperTwo']//div//select"));
        Select dropdownCounties = new Select(staticDropdownCountries);
        dropdownCounties.selectByValue("Spain");
        driver.findElement(By.className("chkAgree"));
        driver.findElement(By.xpath("//button[normalize-space()='Proceed']"));
        // Proceed with further actions
        driver.quit();
    }
}
