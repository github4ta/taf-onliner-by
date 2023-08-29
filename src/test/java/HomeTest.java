import org.junit.jupiter.api.*;

public class HomeTest extends BaseTest {
    @DisplayName("Test: Open home page and get copywriter")
    @Test
    public void testHomePageOpened() {
        HomePage homePage = new HomePage(driver);
        String actualCopywriterText = homePage.getCopyrightText();
        String extendsCopywriterText = "© 2001—2023 Onlíner";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }
}

