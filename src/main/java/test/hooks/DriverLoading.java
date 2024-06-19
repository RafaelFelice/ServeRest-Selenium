package test.hooks;

import org.apache.commons.io.FileUtils;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;

public class DriverLoading {
    private static WebDriver driver; //instancia do webdriver

    private DriverLoading() { //construtor - para acessar algo dessa classe precisa ser por um método publico estático, no caso seria o getDriver
    }

    public static Browser browser = Browser.CHROME;
    public enum Browser{
        CHROME,
        FIREFOX
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser){
                case FIREFOX: driver = new FirefoxDriver(); break;
                case CHROME: driver = new ChromeDriver(); break;
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafae\\driver\\chromedriver.exe");
            driver.manage().window().maximize();
            driver.get("https://front.serverest.dev/login");
        }
        return driver;
    }

    public static void closeDriver() {
        try {
            if (driver != null && ((RemoteWebDriver) driver).getSessionId() != null) {
                driver.quit();
            }
        } catch (NoSuchSessionException e) {

        } catch (Exception e) {
            System.out.println("Erro ao finalizar o driver: " + e.getMessage());
        } finally {
            driver = null;
        }
    }

//    @Rule
//    public static TestName testName = new  TestName();
//
//    public static void takeScreenshot() throws IOException {
//        if (driver != null) {
//            TakesScreenshot screenshot = (TakesScreenshot) driver;
//            File file = screenshot.getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(file, new File(testName.getMethodName() + ".jpg"));
//        }
//    }

}
