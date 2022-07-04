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
        driver.get("http://mail.ru");
        By findBy = By.className(NEWS_MAIN_TITLE);
        WebDriverWait wait = DriverSettings.getWait();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(findBy)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(findBy)));
        String text = driver.findElement(findBy).getText();
        System.out.println(text);
        sleepALot();

        driver.get("https://www.radiokot.ru/forum/ucp.php?mode=login");
        driver.findElement(By.xpath("//*[@id=\"wrapcentre\"]/form/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[2]/input")).sendKeys("LOGIN");
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"wrapcentre\"]/form/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/input")).sendKeys("PASSWORD");
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"wrapcentre\"]/form/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td[2]/input")).click();
        sleepABit();
        driver.findElement(By.xpath("//*[@id=\"wrapcentre\"]/form/table/tbody/tr[2]/td[2]/table/tbody/tr[4]/td[2]/input")).click();
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
