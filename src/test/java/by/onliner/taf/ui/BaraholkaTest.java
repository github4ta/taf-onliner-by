package by.onliner.taf.ui;

import by.onliner.taf.po.BaraholkaPage;
import org.junit.jupiter.api.*;

public class BaraholkaTest extends BaseTest {
    @Test
    @DisplayName("UI0024 - проверка текста заголовка страницы Барахолка")
    void testBaraholkaOpened() {
        Assertions.assertEquals("Барахолка", new BaraholkaPage().getFormHeaderText());
    }
}
