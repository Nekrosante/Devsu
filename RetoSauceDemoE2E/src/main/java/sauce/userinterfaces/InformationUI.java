package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class InformationUI extends PageObject {
    public static final Target INPUT_FIRST_NAME = Target.the("Text box to enter the first name")
            .located(By.id("first-name"));
    public static final Target INPUT_LAST_NAME = Target.the("Text box to enter the last name")
            .located(By.id("last-name"));
    public static final Target INPUT_CODE_POSTAL = Target.the("Text box to enter the postal code")
            .located(By.id("postal-code"));
    public static final Target CONTINUE_BUTTON = Target.the("Button to proceed with the purchase")
            .located(By.id("continue"));
    public static final Target CANCEL_BUTTON = Target.the("Button to cancel the purchase")
            .located(By.id("cancel"));
}
