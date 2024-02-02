package sauce.tasks;

//import net.serenitybdd.annotations.Step;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sauce.userinterfaces.InformationUI.*;


public class FillYourInformation implements Task {
    private String firstName;
    private String lastName;
    private String postalCode;
    private Boolean clickContinueButton;

    public static FillYourInformation whit() {return Tasks.instrumented(FillYourInformation.class);}

    @Override
    @Step("{0} completes the personal information form")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(CONTINUE_BUTTON, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Enter.theValue(firstName).into(INPUT_FIRST_NAME),
                Enter.theValue(lastName).into(INPUT_LAST_NAME),
                Enter.theValue(postalCode).into(INPUT_CODE_POSTAL),
                Check.whether(clickContinueButton).andIfSo(Click.on(CONTINUE_BUTTON))
        );
    }
    public FillYourInformation clickContinueButton(Boolean clickContinueButton) {
        this.clickContinueButton = clickContinueButton;
        return this;
    }
    public FillYourInformation firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FillYourInformation lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FillYourInformation postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
