package by.best.project;

import by.best.project.selenium.settings.DriverSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class ApplicationRunner {
    private static final String NEWS_MAIN_TITLE = "news-main__title";
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Hello");
        System.setProperty("webdriver.chrome.driver", args[0]);

        WebDriver driver = DriverSettings.setUpAndGetDriver();
        driver.get("https://row2.vfsglobal.com/PolandBelarus-Appointment/Account/RegisteredLogin?q=shSA0YnE4pLF9Xzwon/x/ASnHZRMROGDyz5YljrTPrmD7weWKDzHm/9+x4kyou3T7EbygDK+7ECJT8O+dWpxGw==");
        By findBy = By.className(NEWS_MAIN_TITLE);
        WebDriverWait wait = DriverSettings.getWait();
        String text = driver.findElement(findBy).getText();
        System.out.println(text);
        sleepALot();

        driver.get("https://row2.vfsglobal.com/PolandBelarus-Appointment/Account/RegisteredLogin?q=shSA0YnE4pLF9Xzwon/x/ASnHZRMROGDyz5YljrTPrmD7weWKDzHm/9+x4kyou3T7EbygDK+7ECJT8O+dWpxGw==");
        driver.findElement(By.xpath("//*[@id=\"EmailId\"]")).sendKeys("LOGIN");
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys("PASSWORD");
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click();
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"btnSubmit\"]")).click();
        sleepABit();

        driver.quit();
    }

    public static void sleepABit() {
        try {
            Thread.sleep(random.nextInt(300) + 120);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleepALot() {
        try {
            Thread.sleep(random.nextInt(3000) + 2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
