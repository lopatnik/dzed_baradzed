package by.best.project.selenium.settings;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.logging.Level;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DriverSettings {
    private static final String PROFILE = "Profile 3";
    private static WebDriverWait wait;

    private static final String NAVIGATOR_TO_UNDEFINED =
            "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})";

    public static WebDriver setUpAndGetDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
//        options.addArguments("user-data-dir=c:/Users/Tok/AppData/Local/Google/Chrome/User Data/" + PROFILE);

        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        options.setExperimentalOption("useAutomationExtension", false);

        System.setProperty("webdriver.chrome.silentOutput", "true");
        java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);

        final ChromeDriver driver = new ChromeDriver(options);
        ((JavascriptExecutor) driver).executeScript(NAVIGATOR_TO_UNDEFINED);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
