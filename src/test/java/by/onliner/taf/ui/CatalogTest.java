package by.onliner.taf.ui;

import by.onliner.taf.po.CatalogPage;
import by.onliner.taf.po.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CatalogTest extends BaseTest{

    @DisplayName("UI0020 - проверка открытия страницы Каталог")
    @Test
    public void  testCatalogOpened(){
        HomePage homePage = new HomePage(driver);
        CatalogPage catalogPage = new CatalogPage(driver);
        homePage.clickCatalogLink();
        String actualCatalogTitleText = catalogPage.getCatalogTitle();
        String excpectedCatalogTitleText = "Каталог";
        Assertions.assertEquals(excpectedCatalogTitleText, actualCatalogTitleText);
    }
}
