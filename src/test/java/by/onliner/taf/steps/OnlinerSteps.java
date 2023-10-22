package by.onliner.taf.steps;

import by.onliner.taf.po.BaraholkaPage;
import by.onliner.taf.po.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OnlinerSteps {

    @Given("User is on the Home page")
    @When("User opens Home page")
    public void openHomePage() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
    }

    @When("User clicks Baraholka link")
    public void userClicksBaraholkaLink() {
        HomePage homePage = new HomePage();
        homePage.clickBaraholkaLink();
    }

    @Then("User is on Baraholka page")
    public void userIsOnBaraholkaPage() {
        BaraholkaPage baraholkaPage = new BaraholkaPage();
        Assertions.assertEquals("Барахолка", baraholkaPage.getFormHeaderText());
    }
}
