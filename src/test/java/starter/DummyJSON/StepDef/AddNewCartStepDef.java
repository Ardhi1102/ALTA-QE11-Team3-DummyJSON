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

public class AddNewCartStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Post add new cart with valid json")
    public void postAddNewCartWithValidJson() {
        File json = new File(Constants.Carts_Body + "/AddNewUserValidBody.json");
        cartsAPI.postAddNewCarts(json);
    }

    @When("Send request post add new cart with valid json")
    public void sendRequestPostAddNewCartWithValidJson() {
        SerenityRest.when()
                .post(CartsAPI.POST_ADD_CARTS);
    }

    @And("Validate add new cart JSON schema")
    public void validateAddNewCartJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/AddNewUserValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));

    }

    @Given("Post add new cart with empty json")
    public void postAddNewCartWithEmptyJson() {
        File json = new File(Constants.Carts_Body + "/BlankBody.json");
        cartsAPI.postAddNewCarts(json);

    }

    @When("Send request post add new cart with empty json")
    public void sendRequestPostAddNewCartWithEmptyJson() {
        SerenityRest.when()
                .post(CartsAPI.POST_ADD_CARTS);
    }
}
