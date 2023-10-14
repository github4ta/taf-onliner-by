package com.bing.taf.ui;

import com.bing.taf.po.ResultPage;
import com.bing.taf.utils.Resources;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class HomeTest extends BaseTest {
    @DisplayName("Test search")
    @Test
    public void testHomePageOpened() {
        ResultPage resultPage = new ResultPage()
                .typeTextSearchInput()
                .clickSearchButton();

        for (WebElement resultItem : resultPage.getResultHeaderList()) {
            if (
                    resultItem.getAttribute("href").equals(Resources.EXPECTED_LINK)
                    && resultItem.getText().equals(Resources.EXPECTED_HEADER)
            ) {
                Assertions.assertTrue(true);
                return;
            }
        }
        Assertions.fail();
    }
}
