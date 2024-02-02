package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class YourCartUI extends PageObject {
    public static final Target REMOVE_ITEM_1 = Target.the("Button to remove item number one")
            .located(By.id("remove-sauce-labs-fleece-jacket"));
    public static final Target REMOVE_ITEM_2 = Target.the("Button to remove item number two")
            .located(By.id("remove-sauce-labs-onesie"));
    public static final  Target CONTINUE_SHOPING = Target.the("Button to go back to the product page")
            .located(By.id("continue-shopping"));
    public static final  Target CHECKOUT = Target.the("Button to complete the purchase")
            .located(By.id("checkout"));
}
