package by.onliner.taf.po;

import by.onliner.taf.singleton.Singleton;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class RealtyPage {
    private WebDriver driver;
    private String saleLink = "//span[@class='project-navigation__sign'][text()='Продажа']";
    private String rentLink = "//span[@class='project-navigation__sign'][text()='Аренда']";
    private By apartmentButton = By.xpath("//span[@class='filter__item-inner'][text()='Квартира']");
    private By oneRoomApartmentButton = By.xpath("//span[@class='filter__item-inner'][text()='1']");
    private By minPriceInput = By.xpath("//*[@id=\"search-filter-price-from\"]");
    private By maxPriceInput = By.xpath("//*[@id=\"search-filter-price-to\"]");
    private By cityInput = By.xpath("//input[@placeholder ='Город, улица']");
    private By foundApartment = By.xpath("//*[@id=\"search-filter-results\"]/div[1]/div/div[2]/a[1]");
    private By realPrice = By.xpath("//span[@class='apartment-bar__price-value apartment-bar__price-value_complementary']");
    private By realRoomApartment = By.xpath("//span[@class='apartment-bar__value']");
    private By realCityApartment = By.xpath(" //div[@class='apartment-info__sub-line apartment-info__sub-line_large']");

    public RealtyPage() {
        this.driver = Singleton.getDriver();
    }

    public String getTextSaleLink() {
        // TODO refactor with JSexecutor
        WebElement textSaleLinkElement = driver.findElement(By.xpath(saleLink));
        return textSaleLinkElement.getText();
    }

    public String getTextRentLink() {
        // TODO refactor with JSexecutor
        WebElement textRentLink = driver.findElement(By.xpath(rentLink));
        return textRentLink.getText();
    }

    public void clickRentButton() {
        WebElement clickRentButton = driver.findElement(By.xpath(rentLink));
        clickRentButton.click();
    }

    public void getSearchResult() {
        driver.findElement(apartmentButton).click();
        driver.findElement(oneRoomApartmentButton).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", driver.findElement(minPriceInput));
        driver.findElement(minPriceInput).sendKeys("200");
        ((JavascriptExecutor) driver).executeScript("arguments[0].value = '';", driver.findElement(maxPriceInput));
        driver.findElement(maxPriceInput).sendKeys("300");
        driver.findElement(cityInput).sendKeys("Минск");
        driver.findElement(foundApartment).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        String priceText = driver.findElement(realPrice).getText();
        int price = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));
        String roomsText = driver.findElement(realRoomApartment).getText();
        String cityText = driver.findElement(realCityApartment).getText();
        boolean priceInRange = price >= 200 && price <= 300;
        boolean isOneRoomApartment = roomsText.contains("1-комнатная квартира");
        boolean isCityMinsk = cityText.contains("Минск");
        if (priceInRange && isOneRoomApartment && isCityMinsk) {
            System.out.println("Условия соответствуют");
        } else {
            System.out.println("Условия не соответствуют");
        }
    }
}


