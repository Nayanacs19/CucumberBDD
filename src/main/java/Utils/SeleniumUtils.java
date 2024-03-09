package Utils;

import static driver.DriverManager.*;
import constants.StringConstrants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void click(By by, String waitStrategy){
        if (waitStrategy.equalsIgnoreCase(StringConstrants.PRESENT)) {
            waitUntilElementPresent(by).click();
        } else if(waitStrategy.equalsIgnoreCase(StringConstrants.CLICKABLE)) {
            waitUntilElementToBeClickable(by).click();
        } else {
            System.out.printf("invalid");;
        }
    }
    public static void sendKeys(By by, String value){
        waitUntilElementPresent(by).sendKeys(value);
    }
    private static WebElement waitUntilElementPresent(By by) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(4));
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }
    private static WebElement waitUntilElementToBeClickable(By by){
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), Duration.ofSeconds(3));
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public static String getTitle(By by){
        return waitUntilElementPresent(by).getText();
    }

    public static String getCurrentUrl(){
        return getDriver().getCurrentUrl();
    }

}
