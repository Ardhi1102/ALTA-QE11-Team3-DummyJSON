package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CartsAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;

public class SingleCartStepDef {
    @Steps
    CartsAPI cartsAPI;
    @Given("Get single cart with valid parameter id {}")
    public void getSingleCartWithValidParameterId(int id) {
        cartsAPI.getSingleCart(id);
    }

    @When("Send request get single cart with valid parameter id")
    public void sendRequestGetSingleCartWithValidParameterId() {
        SerenityRest.when()
                .get(CartsAPI.GET_SINGLE_CARTS);
    }

    @Then("Status code should be {int} OK")
    public void statusCodeShouldBeOK(int code) {
        SerenityRest.then().statusCode(code);
    }

    @And("Response body page should be display userId {} and total {}")
    public void andResponseBodyPageShouldBeDisplayFirstNameAndLastName(int userId, int total) {
        SerenityRest.and()
                .body("userId", equalTo(userId))
                .body("total", equalTo(total));
    }

    @And("Validate get single user JSON schema")
    public void validateGetSingleUserJSONSchema() {
        File json = new File(Constants.Carts_Schema + "/SingleCartValidParameter.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Then("Status code should be {int} Not Found")
    public void statusCodeShouldBeNotFound(int code) {
        SerenityRest.then().statusCode(code);
    }

    @Given("Get single cart with exceed parameter id {}")
    public void getSingleCartWithExceedParameterId(int id) {
        cartsAPI.getSingleCart(id);
    }

    @Given("Get single cart with invalid parameter id {string}")
    public void getSingleCartWithInvalidParameterId(String id) {
        cartsAPI.getSingleCartInvalidParam(id);
    }

    @Then("Status code should be {int} Bad Request")
    public void statusCodeShouldBeBadRequest(int code) {
        SerenityRest.then()
                .statusCode(code);
    }
}