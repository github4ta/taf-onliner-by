package by.onliner.taf.steps;

import by.onliner.taf.po.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class OnlinerSteps {

    @Given("User is on the Home page")
    @When("User opens Home page")
    public void openHomePage() {
        HomePage homePage = new HomePage();
        homePage.openHomePage();
    }
}
