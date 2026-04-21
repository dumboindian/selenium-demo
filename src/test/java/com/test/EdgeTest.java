import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.jupiter.api.Test;

public class EdgeTest {

    @Test
    public void testEdge() {
        System.setProperty("webdriver.edge.driver", "C:\\selenium-demo\\drivers\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.google.com");

        System.out.println("Title: " + driver.getTitle());

        driver.quit();
    }
}