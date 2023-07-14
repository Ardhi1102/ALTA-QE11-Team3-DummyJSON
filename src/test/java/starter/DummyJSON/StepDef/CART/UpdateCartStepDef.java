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

public class UpdateCartStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Put update cart with valid json and valid parameter id {}")
    public void putUpdateCartWithValidJsonAndValidParameter(int id) {
        File json = new File(Constants.Carts_Body + "/UpdateCartBody.json");
        cartsAPI.putUpdateCarts(id, json);
    }

    @When("Send request put update cart with valid json and valid parameter")
    public void sendRequestPutUpdateCartWithValidJsonAndValidParameter() {
        SerenityRest.when()
                .put(CartsAPI.PUT_UPDATE_CARTS);
    }

    @And("Validate update cart JSON schema")
    public void validateUpdateCartJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/UpdateUserValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Put update cart with valid json and blank parameter id")
    public void putUpdateCartWithValidJsonAndBlankParameter() {
        cartsAPI.putUpdateCartsBlank();
    }

    @When("Send request put update cart with valid json and blank parameter")
    public void sendRequestPutUpdateCartWithValidJsonAndBlankParameter() {
        SerenityRest.when()
                .put(CartsAPI.PUT_BLANK_UPDATE_CARTS);
    }

    @Given("Put update cart with blank json and valid parameter id {}")
    public void putUpdateCartWithBlankJsonAndValidParameter(int id) {
        File json = new File(Constants.Carts_Body + "/BlankBody.json");
        cartsAPI.putUpdateCarts(id, json);
    }

    @When("Send request put update cart with blank json and valid parameter")
    public void sendRequestPutUpdateCartWithBlankJsonAndValidParameter() {
        SerenityRest.when()
                .put(CartsAPI.PUT_UPDATE_CARTS);
    }

    @Given("Put update cart with additional request body made use id {}")
    public void putUpdateCartWithAdditionalRequestBodyMade(int id) {
        File json = new File(Constants.Carts_Body + "/UpdateCartMadeBody.json");
        cartsAPI.putUpdateCarts(id, json);
    }

    @When("Send request put update cart with additional request body made")
    public void sendRequestPutUpdateCartWithAdditionalRequestBodyMade() {
        SerenityRest.when()
                .put(CartsAPI.PUT_UPDATE_CARTS);
    }
}
