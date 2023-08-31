package by.onliner.taf.ui;

import by.onliner.taf.po.BaraholkaPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.*;

public class BaraholkaTest extends BaseTest {
    @BeforeEach
    void beforEachBaraholkaTest() {
        HomePage homePage = new HomePage(driver);
        homePage.clickBaraholkaLink();
    }

    @Test
    @DisplayName("Проверка текста заголовка страницы Барахолка")
    void testaraholkaOpened() {
        Assertions.assertEquals("Барахолка", new BaraholkaPage(driver).getFormHeaderText());
    }

    @AfterEach
    void afterEachBaraholkaTest() {
        driver.quit();
    }
}
