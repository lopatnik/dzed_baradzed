package by.best.project;

import by.best.project.selenium.settings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApplicationRunner {
    private static final String NEWS_MAIN_TITLE = "news-main__title";

    public static void main(String[] args) {
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver", args[0]);

        WebDriver driver = DriverSettings.setUpAndGetDriver();
        driver.get("http://mail.ru");
        WebDriverWait wait = DriverSettings.getWait();

        By findBy = By.className(NEWS_MAIN_TITLE);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(findBy)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(findBy)));
        String text = driver.findElement(findBy).getText();
        System.out.println(text);
        driver.quit();
    }
}
