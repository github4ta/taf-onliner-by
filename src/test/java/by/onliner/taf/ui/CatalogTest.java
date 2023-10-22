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
        HomePage homePage = new HomePage();
        CatalogPage catalogPage = new CatalogPage();
        homePage.clickCatalogLink();
        String actualCatalogTitleText = catalogPage.getCatalogHeader();
        String excpectedCatalogTitleText = "КаталогВсе суперцены!";
        Assertions.assertEquals(excpectedCatalogTitleText, actualCatalogTitleText);
    }
}
