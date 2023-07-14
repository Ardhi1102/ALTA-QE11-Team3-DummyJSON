package starter.DummyJSON.StepDef.AUTH;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.AuthAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class LoginStepDef {
    @Steps
    AuthAPI authAPI;
    @Given("Post login with valid email and password")
    public void postLoginWithValidEmailAndPassword() {
        File json = new File(Constants.Auth_Body + "/LoginValidEmailPassBody.json");
        authAPI.postLogin(json);
    }

    @When("Send request post login with valid email and password")
    public void sendRequestPostLoginWithValidEmailAndPassword() {
        SerenityRest.when()
                .post(AuthAPI.POST_LOGIN);
    }

    @Given("Post login with valid email and invalid password")
    public void postLoginWithValidEmailAndInvalidPassword() {
        File json = new File(Constants.Auth_Body + "/LoginValidEmailInvalidPassBody.json");
        authAPI.postLogin(json);
    }

    @When("Send request post login with valid email and invalid password")
    public void sendRequestPostLoginWithValidEmailAndInvalidPassword() {
        SerenityRest.when()
                .post(AuthAPI.POST_LOGIN);
    }

    @Given("Post login with invalid email and valid password")
    public void postLoginWithInvalidEmailAndValidPassword() {
        File json = new File(Constants.Auth_Body + "/LoginInvalidEmailValidPassBody.json");
        authAPI.postLogin(json);
    }

    @When("Send request post login with invalid email and valid password")
    public void sendRequestPostLoginWithInvalidEmailAndValidPassword() {
        SerenityRest.when()
                .post(AuthAPI.POST_LOGIN);
    }

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

    @And("Validate login success user JSON schema")
    public void validateLoginSuccessUserJSONSchema() {
        File json = new File(Constants.Auth_Schema + "/LoginSuccess.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate login unsuccess user JSON schema")
    public void validateLoginUnsuccessUserJSONSchema() {
        File json = new File(Constants.Auth_Schema + "/LoginUnsuccess.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
