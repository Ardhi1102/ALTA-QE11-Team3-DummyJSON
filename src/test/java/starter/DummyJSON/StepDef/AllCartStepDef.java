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

public class AllCartStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Get all charts with valid path")
    public void getAllChartsWithValidPath() {
        cartsAPI.getAllCart();
    }

    @When("Send request get all carts with valid path")
    public void sendRequestGetAllCartsWithValidPath() {
        SerenityRest.when()
                .get(CartsAPI.GET_ALL_CARTS);
    }

    @Given("Get all carts with invalid path")
    public void getAllCartsWithInvalidPath() {
        cartsAPI.getAllInvalidCart();
    }

    @When("Send request get all carts with invalid path")
    public void sendRequestGetAllCartsWithInvalidPath() {
        SerenityRest.when()
                .get(CartsAPI.GET_ALL_INVALID_CARTS);
    }

    @And("Validate all cart JSON schema")
    public void validateAllCartUserJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/AllCartValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
