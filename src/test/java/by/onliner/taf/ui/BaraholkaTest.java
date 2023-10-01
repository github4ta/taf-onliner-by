package by.onliner.taf.ui;

import by.onliner.taf.po.BaraholkaPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.*;

public class BaraholkaTest extends BaseTest {
    @BeforeEach
    public void beforEachBaraholkaTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickBaraholkaLink();
    }
    @Test
    @DisplayName("UI0024 - проверка текста заголовка страницы Барахолка")
    public void testBaraholkaOpened() {
        Assertions.assertEquals("Барахолка", new BaraholkaPage(driver).getFormHeaderText());
    }
}
