package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
//import net.serenitybdd.annotations.DefaultUrl;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://www.saucedemo.com/")
public class SwagHomeUI extends PageObject {
    public static final Target INPUT_USER = Target.the("Text box to enter the username")
            .located(By.id("user-name"));
    public static final Target INPUT_PASSWORD = Target.the("Text box to enter the password")
            .located(By.id("password"));
    public static final Target ENTER_BUTTON = Target.the("Button to log in")
            .located(By.id("login-button"));

}
