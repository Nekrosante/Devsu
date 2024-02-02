package sauce.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import sauce.interactions.OpenUp;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import sauce.questions.Visualize;
import sauce.tasks.AddProducts;
import sauce.tasks.EditTheShoppingCart;
import sauce.tasks.FillYourInformation;
import sauce.tasks.Login;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sauce.userinterfaces.OverviewUI.*;


public class PurchaseStep {
    @Before
    public void setStage() { OnStage.setTheStage(new OnlineCast());}

    @Given("access to a standard user on the Swag Labs login page")
    public void accessToAStandardUser() {
        OnStage.theActorCalled("StandardUser")
                .wasAbleTo(
                        OpenUp.thePage()
                );
    }
    @Given("enters valid credentials as a standard user")
    public void entersValidCredentialsAsAStandardUser() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Login.whit()
                                .username("standard_user")
                                .password("secret_sauce")
                                .andClickLoginButton(true)
                );
    }
    @When("adds the products to the shopping cart")
    public void addsTheProductsToTheShoppingCart() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        AddProducts.whit()
                                .item1(true)
                                .item2(true)
                                .andClickOnShoppingCart(true)
                );
    }

    @And("completes the purchase by entering their information")
    public void completesThePurchaseByEnteringTheirInformation() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                      EditTheShoppingCart.whit()
                              .removeItem1(false)
                              .removeItem2(false)
                              .andClickOnCheckOut(true),
                        FillYourInformation.whit()
                                .firstName("Luis")
                                .lastName("Arcia")
                                .postalCode("050002")
                                .clickContinueButton(true),
                        WaitUntil.the(FINISH_BUTTON, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                        Click.on(FINISH_BUTTON)
        );
    }

    @Then("validates the verification message {string}")
    public void validatesTheVerificationMessage(String message) {
        //Thank you for your order!
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        Visualize.thePurshaseConfirmacion(message)
                );

    }

    @And("completes the purchase by removing an item from the shopping cart")
    public void completesThePurchaseByRemovingAnItemFromTheShoppingCart() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        EditTheShoppingCart.whit()
                                .removeItem1(false)
                                .removeItem2(true)
                                .andClickOnCheckOut(true),
                        FillYourInformation.whit()
                                .firstName("Luis M")
                                .lastName("Arcia")
                                .postalCode("050002")
                                .clickContinueButton(true),
                        WaitUntil.the(FINISH_BUTTON, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                        Click.on(FINISH_BUTTON)
                );
    }
}
