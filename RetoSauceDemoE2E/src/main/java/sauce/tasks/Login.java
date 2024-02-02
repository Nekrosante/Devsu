package sauce.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
//import net.serenitybdd.annotations.Step;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sauce.userinterfaces.SwagHomeUI.*;

public class Login implements Task {
    private String password;
    private String username;
    private Boolean clickLoginButton;
    @Override
    @Step("{0} logs in with his credentials")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_USER, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Enter.theValue(username).into(INPUT_USER),
                Enter.theValue(password).into(INPUT_PASSWORD),
                Check.whether(clickLoginButton)
                        .andIfSo(Click.on(ENTER_BUTTON))
        );
    }
    public static Login whit() {
        return Tasks.instrumented(Login.class);
    }
    public Login password(String password) {
        this.password = password;
        return this;
    }
    public Login username(String username) {
        this.username = username;
        return this;
    }
    public Login andClickLoginButton(Boolean clickLoginButton) {
        this.clickLoginButton = clickLoginButton;
        return this;
    }
}
