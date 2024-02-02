package reto.ApisE2E.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.util.EnvironmentVariables;

import javax.sound.midi.Soundbank;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class StepsPetStoreUsers {
    private EnvironmentVariables environmentVariables;
    private Actor actor;

    @Before
    public void setStage() {
        OnStage.setTheStage(new OnlineCast());
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        actor = Actor.named("Regular user").whoCan(CallAnApi.at(baseURI));
    }
    @Given("that the services of the pet store are available")
    public void thatTheServicesOfThePetStoreAreAvailable() {
        actor.attemptsTo(
                        Get.resource("/swagger.json")
                );
        actor.should(
                seeThatResponse("all the services of the pet store are available",
                        response -> response.statusCode(200)
                        )
                );
    }
    @When("submit the data of a valid user to the Create User method")
    public void submitTheDataOfAValidUserToTheMethod() {
        actor.attemptsTo(
                Get.resource("/user/login?username={username}&password={password}").with(request -> request.pathParam("username", "Arcia").pathParam("password",123456))
        );
        actor.should(
                seeThatResponse("the login was successful with a valid username and password",
                        response -> response.statusCode(200)
                )
        );
        actor.attemptsTo(
                Post.to("/user")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"id\": 552211,\"username\": \"Nekros\",\"firstName\": \"Luis\",\"lastName\": \"Arcia\",\"email\": \"larcia@arcia.com\",\"password\": \"123789\",\"phone\": \"32165478\",\"userStatus\": 0}")
                        )
        );
    }
    @Then("validate the response from the user creation service")
    public void validateTheResponseFromTheUserCreationService() {
        actor.should(
                seeThatResponse("Status code 200 in the response from the user creation service",
                        response -> response.statusCode(200)
                )
        );
    }

    @When("execute the search method with a valid username")
    public void executeTheSearchMethodWithAValidUsername() {
        actor.attemptsTo(
                Get.resource("/user/{username}").with(request -> request.pathParam("username", "Nekros"))
        );
        actor.should(
                seeThatResponse("Status code 200 in the response from the user search method",
                        response -> response.statusCode(200)
                )
        );
    }

    @Then("validate that the search is successful")
    public void validateThatTheSearchIsSuccessful() {
        actor.should(
                seeThatResponse("The service response contains information consistent with the searched user",
                        response ->response.statusCode(200).body("id",equalTo(552211),"firstName",equalTo("Luis"))
                ));
    }

    @When("execute the user update method with valid data")
    public void executeTheUserUpdateMethodWithValidData() {
        actor.attemptsTo(
                Put.to("/user/{username}")
                        .with(request -> request.pathParam("username", "Nekros")
                                .body("{\"id\": 552211,\"username\": \"Nekros\",\"firstName\": \"Miguel\",\"lastName\": \"Arcia\",\"email\": \"miguel@arcia.com\",\"password\": \"123789\",\"phone\": \"32165478\",\"userStatus\": 0}")
                        ));
    }

    @Then("validate the user update using the search method")
    public void validateTheUserUpdateUsingTheSearchMethod() {
        actor.attemptsTo(
                Get.resource("/user/{username}").with(request -> request.pathParam("username", "Nekros"))
        );
        actor.should(
                seeThatResponse("The editing of the name and email was successful",
                        response -> response.statusCode(200)
                                .body("id",equalTo(552211),"firstName",equalTo("Miguel"),"email",equalTo("miguel@arcia.com"))
                )
        );
    }

    @When("create a new user using the corresponding method")
    public void createANewUserUsingTheCorrespondingMethod() {
        actor.attemptsTo(
                Post.to("/user")
                        .with(request -> request.header("Content-Type", "application/json")
                                .body("{\"id\": 852561,\"username\": \"Batman\",\"firstName\": \"Bruce\",\"lastName\": \"Wayne\",\"email\": \"huerfano@gotica.com\",\"password\": \"123789\",\"phone\": \"32165478\",\"userStatus\": 0}")
                        )
        );
        actor.should(
                seeThatResponse("Successful creation of the new user",
                        response -> response.statusCode(200)
                )
        );
    }

    @And("delete the user from the pet store")
    public void deleteTheUserFromThePetStore() {
        actor.attemptsTo(
                Delete.from("/user/{username}").with(request -> request.pathParam("username", "Batman"))
        );
        actor.should(
                seeThatResponse("Successful deletion of the new user",
                        response -> response.statusCode(200)
                                .body("message",equalTo("Batman"))
                )
        );
    }

    @Then("verify with the search method that the user is deleted")
    public void verifyWithTheSearchMethodThatTheUserIsDeleted() {
        actor.attemptsTo(
                Get.resource("/user/{username}").with(request -> request.pathParam("username", "Batman"))
        );
        actor.should(
                seeThatResponse("The search method did not find the deleted user",
                        response -> response.statusCode(404)
                                .body("message",equalTo("User not found"))
                )
        );
    }
}
