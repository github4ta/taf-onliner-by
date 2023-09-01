package by.onliner.taf.ui;

import by.onliner.taf.po.ABPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ABTest extends BaseTest {

    @DisplayName("UI0021 - проверка открытия страницы Автобарахолка")
    @Test
    public void testABOpened() {
        HomePage homePage = new HomePage(driver);
        ABPage abPage = new ABPage(driver);
        homePage.clickABLink();
        Assertions.assertEquals("Автобарахолка", abPage.getAbHeader());
    }
}
