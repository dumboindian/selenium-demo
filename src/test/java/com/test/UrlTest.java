import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class UrlTest {

    @Test
    public void verifyURL() {

        // ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "C:\\selenium-demo\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.google.com");

            String url = driver.getCurrentUrl();
            System.out.println("URL: " + url);

            Assertions.assertTrue(url.contains("google"));

        } finally {
            driver.quit();
        }
    }
}