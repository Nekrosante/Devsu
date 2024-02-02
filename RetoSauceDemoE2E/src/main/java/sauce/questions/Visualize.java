package sauce.questions;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static java.time.Duration.ofSeconds;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sauce.userinterfaces.ConfirmationUI.VERIFICATION_MESSAGE;

public class Visualize {
    public static Performable thePurshaseConfirmacion(String message) {
        return Task.where("Visualizes the expected confirmation message",
                WaitUntil.the(VERIFICATION_MESSAGE, isVisible()).forNoMoreThan(ofSeconds(15)),
                Ensure.that(VERIFICATION_MESSAGE).text().isEqualTo(message)
        );

    }
}
