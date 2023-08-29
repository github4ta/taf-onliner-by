import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeTest extends BaseTest {
    @DisplayName("Test: Open home page and get copywriter")
    @Test
    public void testHomePageOpened() {
        WebElement copywriterElement = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='footer-style__copy']")));
        String actualCopywriterText = copywriterElement.getText();
        String extendsCopywriterText = "© 2001—2023 Onlíner";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }
}

