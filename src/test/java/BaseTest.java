import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    WebDriver driver = new ChromeDriver();
    @BeforeEach
    public void driverSetup() {
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
    }
    @AfterEach
    public void driverShutDown() {
        driver.quit();
    }
}
