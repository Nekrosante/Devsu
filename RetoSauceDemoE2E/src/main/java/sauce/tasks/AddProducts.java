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
import static sauce.userinterfaces.ProductsUI.*;

public class AddProducts implements Task {
    private Boolean item1;
    private Boolean item2;
    private Boolean shoppingCart;

    @Override
    @Step("{0} adds these products")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ITEM_1, isVisible()).forNoMoreThan(Duration.ofSeconds(15)),
                Check.whether(item1).andIfSo(Click.on(ITEM_1)),
                Check.whether(item2).andIfSo(Click.on(ITEM_2)),
                Check.whether(shoppingCart).andIfSo(Click.on(SHOPCART_ICON))
        );
    }
    public static AddProducts whit() {
        return Tasks.instrumented(AddProducts.class);
    }

    public AddProducts item1(Boolean item1) {
        this.item1 = item1;
        return this;
    }
    public AddProducts item2(Boolean item2) {
        this.item2 = item2;
        return this;
    }
    public AddProducts andClickOnShoppingCart(Boolean shoppingCart) {
        this.shoppingCart = shoppingCart;
        return this;
    }
}
