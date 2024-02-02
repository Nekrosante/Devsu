package sauce.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "sauce.stepdefinitions",
        tags = "@purchase",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class CucumberTestSuite {
}

