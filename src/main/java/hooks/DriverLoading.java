package hooks;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverLoading {
    private static WebDriver driver;

    private DriverLoading() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            System.setProperty("webdriver.chrome.driver", "C:\\Users\\rafae\\driver\\chromedriver.exe");
            driver = new ChromeDriver(options);
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

}
