package by.onliner.taf.ui.steps;

import by.onliner.taf.po.ABPage;
import by.onliner.taf.po.BaraholkaPage;
import by.onliner.taf.po.CatalogPage;
import by.onliner.taf.po.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
public class OnlinerSteps {
    public static HomePage homePage;

    @Given("User is on the Home page")
    @When("User opens Home page")
    public static void openHomePage() {
        homePage = new HomePage();
        homePage.openHomePage();
    }

    @Then("Home page is opened")
    public static void getHomePageResult() {
        String actualCopywriterText = homePage.getCopyright();
        String extendsCopywriterText = "© 2001—2023 Onlíner";
        Assertions.assertEquals(extendsCopywriterText, actualCopywriterText);
    }

    @When("User clicks Catalog link")
    public void userClicksCatalogLink() {
        homePage.clickCatalogLink();
     }
    @Then("Catalog page is opened")
    public void catalogPageIsOpened() {
        CatalogPage catalogPage = new CatalogPage();
        Assertions.assertEquals("КаталогВсе суперцены!", catalogPage.getCatalogHeader());
    }

    @When("User clicks Baraholka link")
    public void userClicksBaraholkaLink() {
        homePage.clickBaraholkaLink();
       }

    @Then("User is on Baraholka page")
    public void userIsOnBaraholkaPage() {
        BaraholkaPage baraholkaPage = new BaraholkaPage();
        Assertions.assertEquals("Барахолка",baraholkaPage.getFormHeaderText());
    }

    @When("User clicks Autobaraholaka link")
    public void userClicksAutobaraholakaLink() {
        homePage.clickABLink();
    }

    @Then("Autobaraholka page is opened")
    public void autobaraholkaPageIsOpened() {
        Assertions.assertEquals("Автобарахолка", new ABPage().getAbHeader());
    }




}
