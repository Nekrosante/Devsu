package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ConfirmationUI extends PageObject {
////h2[(@class='complete-header')]
    public static final Target BACK_BUTTON = Target.the("Button to back to products")
            .located(By.id("back-to-products"));
    public static final Target VERIFICATION_MESSAGE = Target.the("Verification message")
            .located(By.xpath("//h2[(@class='complete-header')]"));
}
