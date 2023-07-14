package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CartsAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class DeleteCartStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Delete cart with valid parameter id {}")
    public void deleteCartWithValidParameterId(int id) {
        cartsAPI.deleteCarts(id);
    }

    @When("Send request delete cart with valid parameter id")
    public void sendRequestDeleteCartWithValidParameterId() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_CARTS);
    }

    @Given("Delete cart with invalid parameter id {string}")
    public void deleteCartWithInvalidParameterId(String id) {
        cartsAPI.deleteCartsInvalidParam(id);
    }

    @When("Send request delete cart with invalid parameter id")
    public void sendRequestDeleteCartWithInvalidParameterId() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_CARTS);
    }

    @Given("Delete cart with blank parameter id")
    public void deleteCartWithBlankParameterId() {
        cartsAPI.deleteCartsBlank();
    }

    @When("Send request delete cart with blank parameter id")
    public void sendRequestDeleteCartWithBlankParameterId() {
        SerenityRest.when()
                .delete(CartsAPI.DELETE_BLANK_CARTS);
    }

    @And("Validate delete cart user JSON schema")
    public void validateDeleteCartUserJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/DeleteSuccess.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
