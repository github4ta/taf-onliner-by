import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    @BeforeEach
    public void driverSetup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
    }
    @AfterEach
    public void driverShutDown() {
       WebDriver driver = new ChromeDriver();
       driver.quit();
    }
}
