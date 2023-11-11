package by.onliner.taf.ui;

import by.onliner.taf.po.ABPage;
import by.onliner.taf.po.BaraholkaPage;
import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.ServicePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest extends BaseTest {
    @Test
    @DisplayName("UI0023 - проверка открытия страницы Услуги")
    void testServiceOpened() {
        HomePage homePage = new HomePage(driver);
        ServicePage servicePage = new ServicePage(driver);
        homePage.clickServiceLink();
        Assertions.assertEquals("Заказы", new ServicePage(driver).getServiceHeaderText());
    }
}
