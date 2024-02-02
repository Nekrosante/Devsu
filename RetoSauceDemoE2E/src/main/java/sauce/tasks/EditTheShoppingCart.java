package sauce.tasks;

//import net.serenitybdd.annotations.Step;
import net.thucydides.core.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.time.Duration;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static sauce.userinterfaces.YourCartUI.*;

public class EditTheShoppingCart implements Task {
    private Boolean item1;
    private Boolean item2;
    private Boolean checkOut;

    @Override
    @Step("{0} edits the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CHECKOUT, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Check.whether(item1).andIfSo(Click.on(REMOVE_ITEM_1)),
                Check.whether(item2).andIfSo(Click.on(REMOVE_ITEM_2)),
                Check.whether(checkOut).andIfSo(Click.on(CHECKOUT))
        );
    }

    public static EditTheShoppingCart whit(){
        return Tasks.instrumented(EditTheShoppingCart.class);
    }

    public EditTheShoppingCart removeItem1(Boolean item1) {
        this.item1 = item1;
        return this;
    }
    public EditTheShoppingCart removeItem2(Boolean item2) {
        this.item2 = item2;
        return this;
    }

    public EditTheShoppingCart andClickOnCheckOut(Boolean checkOut) {
        this.checkOut = checkOut;
        return this;
    }
}
