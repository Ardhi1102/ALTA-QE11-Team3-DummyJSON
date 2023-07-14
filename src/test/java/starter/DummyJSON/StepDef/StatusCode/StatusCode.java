package starter.DummyJSON.StepDef.StatusCode;

import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;

public class StatusCode {

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int code) {
        SerenityRest.then()
                .statusCode(code);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int code) {
        SerenityRest.then()
                .statusCode(code);
    }
    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int code) {
        SerenityRest.then().statusCode(code);
    }
}
