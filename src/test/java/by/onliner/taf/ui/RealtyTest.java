package by.onliner.taf.ui;

import by.onliner.taf.po.HomePage;
import by.onliner.taf.po.RealtyPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RealtyTest extends BaseTest {
    @DisplayName("UI0022 - проверка открытия страницы Дома и квартиры")
    @Test
    public void testRealtyOpened() {
        HomePage homePage = new HomePage();
        RealtyPage realtyPage = new RealtyPage(driver);
        homePage.clickRealtyLink();
        String expectedTextSale = "Продажа";
        String actualTextSale = realtyPage.getTextSaleLink();
        String expectedTextRent = "Аренда";
        String actualTextRent = realtyPage.getTextRentLink();
        Assertions.assertEquals(expectedTextSale, actualTextSale);
        Assertions.assertEquals(expectedTextRent, actualTextRent);
    }

    @DisplayName("UI0029 - проверка работы поля Поиск")
    @Test
    public void testRealtySearched() {
        HomePage homePage = new HomePage();
        homePage.clickRealtyLink();
        RealtyPage realtyPage = new RealtyPage(driver);
        realtyPage.clickRentButton();
        realtyPage.getSearchResult();
    }
}

