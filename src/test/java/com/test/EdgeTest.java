import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class EdgeTest {

    @Test
    public void testGoogleSearch() {

        // Set driver path
        System.setProperty("webdriver.edge.driver", "C:\\selenium-demo\\drivers\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();

        try {
            // Maximize window
            driver.manage().window().maximize();

            // Implicit wait (important for Jenkins stability)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Open Google
            driver.get("https://www.google.com");

            // Check title
            String title = driver.getTitle();
            System.out.println("Page Title: " + title);

            // Assertion (important for testing)
            Assertions.assertTrue(title.contains("Google"), "Title does not match!");

            // Find search box and type query
            WebElement searchBox = driver.findElement(By.name("q"));
            searchBox.sendKeys("Selenium WebDriver");

            // Wait a bit for UI response (optional stability)
            Thread.sleep(2000);

            // Validate search box is displayed
            Assertions.assertTrue(searchBox.isDisplayed(), "Search box not visible");

            System.out.println("Test Passed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            Assertions.fail("Test failed due to exception: " + e.getMessage());

        } finally {
            // Always close browser
            driver.quit();
        }
    }
}