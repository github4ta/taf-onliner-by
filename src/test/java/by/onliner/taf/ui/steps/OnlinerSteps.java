package by.onliner.taf.ui.steps;

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
}
