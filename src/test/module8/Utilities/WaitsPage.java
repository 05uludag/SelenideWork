package Utilities;

import com.codeborne.selenide.SelenideWait;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;


public class WaitsPage {
    static WebDriver driver = WebDriverRunner.getWebDriver();

    /** Implicit wait specicit duration of time */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /** waits for WebDriver */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /** Fluentwait for webDriver */

    public static WebElement FluentlyWaitForVisibility(WebElement element,int timeoutSeconds, int PollingMilliSeconds){
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofMillis(PollingMilliSeconds));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static SelenideWait Wait(){
        return new SelenideWait(driver, 10000,500);
    }



}
