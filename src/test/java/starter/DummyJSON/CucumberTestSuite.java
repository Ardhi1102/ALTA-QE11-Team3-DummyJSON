<<<<<<<< HEAD:src/test/java/DummyJSON/CucumberTestSuite.java
package DummyJSON;
========
package starter.DummyJSON;
>>>>>>>> origin/develop:src/test/java/starter/DummyJSON/CucumberTestSuite.java


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags =  "@Tugas",
        plugin = {"pretty"},
        features = "classpath:features"
)
public class CucumberTestSuite {}
