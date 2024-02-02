package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class OverviewUI extends PageObject {
    public static final Target FINISH_BUTTON = Target.the("Button to finish with the purchase")
            .located(By.id("finish"));
    public static final Target CANCEL_BUTTON = Target.the("Button to cancel the purchase")
            .located(By.id("cancel"));
}
