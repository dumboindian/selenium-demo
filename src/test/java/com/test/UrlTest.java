import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class UrlTest {

    @Test
    public void verifyURL() {

        // Set driver path
        System.setProperty("webdriver.edge.driver", "C:\\selenium-demo\\drivers\\msedgedriver.exe");

        // Headless mode for Jenkins stability
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");

        WebDriver driver = new EdgeDriver(options);

        try {
            // Timeout safety
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open site
            driver.get("https://www.google.com");

            // Get current URL
            String url = driver.getCurrentUrl();
            System.out.println("Current URL: " + url);

            // Assertion (test validation)
            Assertions.assertTrue(url.contains("google"), "URL does not contain google");

        } finally {
            driver.quit();
        }
    }
}