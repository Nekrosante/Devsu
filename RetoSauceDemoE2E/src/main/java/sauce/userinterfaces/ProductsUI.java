package sauce.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class ProductsUI extends PageObject {
    public static final Target ITEM_1 = Target.the("Product page element 1")
            .located(By.id("add-to-cart-sauce-labs-fleece-jacket"));
    public static final Target ITEM_2 = Target.the("Product page element 2")
            .located(By.id("add-to-cart-sauce-labs-onesie"));
    public static final  Target SHOPCART_ICON = Target.the("Shopping cart icon")
            .located(By.xpath("//a[contains(@class,'shopping_cart_link')]"));
}
