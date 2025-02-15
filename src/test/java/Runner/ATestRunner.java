package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/feature/",
        glue = "com.soc.steps",
        monochrome = true,
        //tags = "@atest",
        plugin = { "pretty", "html:target/cucumber/cucumber-prettya.html",
                "json:target/cucumber/cucumber_a.json",
                "junit:target/cucumber/cucumber_a.xml"}
)

public class ATestRunner {
}
