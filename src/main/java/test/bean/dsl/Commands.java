package test.bean.dsl;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.hooks.DriverLoading;

import java.time.Duration;

// Essa class tem por objetivo substituir os métodos genéricos do Selenium por métodos bem descritivos/ específicos
// centralizando a forma de execução e evitando repetição de código.

public class Commands {
    private static final Duration DEFAULT_TIME_WAIT = Duration.ofSeconds(20);


    public static WebDriver getDriver() {
        return DriverLoading.getDriver();
    }

    protected void openUrl(String url) {
        getDriver().get(url);
    }

    protected void sendKeys(String string, By locator) {
        this.isVisible(locator);
        this.getElement(locator).clear();
        this.waitForTextInElement(locator, "");
        this.getElement(locator).sendKeys(string);
    }

    protected void click(By locator) {
        this.isClickable(locator);
        this.getElement(locator).click();
    }

    protected WebElement waitElement(By locator) {
        return (WebElement)(new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean isVisible(By locator) {
        (new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)).until(ExpectedConditions.visibilityOf(this.getElement(locator)));
        return this.getElement(locator).isDisplayed();
    }

    protected boolean isClickable(By locator) {
        (new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)).until(ExpectedConditions.elementToBeClickable(this.getElement(locator)));
        return this.getElement(locator).isDisplayed() && this.getElement(locator).isEnabled();
    }

    protected void waitForTextInElement(By locator, String textToBeWait) {
        (new WebDriverWait(getDriver(), DEFAULT_TIME_WAIT)).until(ExpectedConditions.textToBe(locator, textToBeWait));
    }

    protected boolean isAttachedToHtml(By locator) {
        try {
            this.waitElement(locator);
            return true;
        } catch (Exception var3) {
            return false;
        }
    }

    protected void pressEnter(By locator) {
        this.isVisible(locator);
        this.getElement(locator).sendKeys(new CharSequence[]{Keys.ENTER});
    }

    protected String getTextFromLabel(By locator) {
        return this.getElement(locator).getText().trim();
    }

    protected WebElement getElement(By locator) {
        return this.waitElement(locator);
    }

    public Commands selectElementForText(By locator, String text) throws Exception {
        Thread.sleep(750L);
        (new Select(this.getElement(locator))).selectByVisibleText(text);
        return this;
    }


}


