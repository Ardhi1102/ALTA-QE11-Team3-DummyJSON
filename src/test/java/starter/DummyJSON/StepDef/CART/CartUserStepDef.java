package starter.DummyJSON.StepDef.CART;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CartsAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class CartUserStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Get cart user with valid parameter id {}")
    public void getCartUserWithValidParameterId(int id) {
        cartsAPI.getCartUser(id);
    }

    @When("Send request get cart user with valid parameter id")
    public void sendRequestGetCartUserWithValidParameterId() {
        SerenityRest.when()
                .get(CartsAPI.GET_USER_CARTS);
    }

    @And("Validate get cart user JSON schema")
    public void validateGetCartUserJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/CartUserValidParameter.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get cart user with invalid parameter {string}")
    public void getCartUserWithInvalidParameter(String id) {
        cartsAPI.getCartUserInvalidParameter(id);
    }

    @When("Send request get cart user with invalid parameter id")
    public void sendRequestGetCartUserWithInvalidParameterId() {
        SerenityRest.when()
                .get(CartsAPI.GET_USER_CARTS);
    }

    @Given("Get cart user with exceed parameter id {}")
    public void getCartUserWithExceedParameter(int id) {
        cartsAPI.getCartUser(id);
    }

    @When("Send request get cart user with exceed parameter id")
    public void sendRequestGetCartUserWithExceedParameterId() {
        SerenityRest.when()
                .get(CartsAPI.GET_USER_CARTS);
    }
}
