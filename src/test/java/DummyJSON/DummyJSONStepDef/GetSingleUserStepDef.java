package DummyJSON.DummyJSONStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import DummyJSON.API.GetAllUsersApi;
import DummyJSON.DummyJSONResponses.UsersResponse;
import DummyJSON.Utils.ConstansJOSS;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;
public class GetSingleUserStepDef {


    @Steps
    GetAllUsersApi getAllUsersApi;

    @Given("Get single user with valid id {int}")
    public void getSingleuserwithvalidId (int id){
        getAllUsersApi.getSingleUSer(id);
    }

    @When("Send request get single user")
    public void sendRequestGetSingleUser() {
        SerenityRest.when().get(GetAllUsersApi.GET_SINGLE_USER);
    }
    @Then("Status should return {int} OK")
    public void statusShouldReturnOK(int OK) {
        SerenityRest.then().statusCode(OK);
    }

    @And("Response body should contain id {int} first name {string} last name {string} maiden name {string}")
    public void responseBodyShouldContainIdIdFirstNameFirstNameLastNameLastnameMaidenNameMaidenName(int id, String firstName, String lastName, String maidenName) {
        SerenityRest.then()
                .body(UsersResponse.ID, equalTo(id))
                .body(UsersResponse.fisrtName, equalTo(firstName))
                .body(UsersResponse.lastName, equalTo(lastName))
                .body(UsersResponse.maidenName, equalTo(maidenName));
    }

        @And("Validate get single user with random registered JSON schema")
        public void validateGetSingleUserWithRandomRegisteredJSONSchema() {
            File json = new File(ConstansJOSS.JSON_SCHEMA_GET_ALL_USERS + "/GetSingleUserSchema.json");
            SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(json));
        }
// Get Single User with invalid id
    @Given("Get single user with invalid id {}")
    public void getSingleUserWithValidId(String nilai) {
        getAllUsersApi.getSingleUserWithinvalidId(nilai);
    }

    @When("Send request get single user invalid id")
    public void sendRequestGetSingleUserInvalidId() {
        SerenityRest.when().get(GetAllUsersApi.GET_SINGLE_INVALID_USER);
    }

    @Then("Status should return {int} Bad Request")
    public void statusShouldReturnBadRequest(int BadRequest) {
        SerenityRest.then().statusCode(BadRequest);
    }

//GET decimal
    @Given("Get single user with invalid parameter number decimal {}")
    public void getSingleUserWithInvalidParameterNumberDecimal(float id) {
        getAllUsersApi.getsingleinvaliddecimal(id);
    }

    @When("Send request get single user decimal")
    public void sendRequestGetSingleUserDecimal() {
        SerenityRest.when().get(GetAllUsersApi.GET_SINGLE_INVALID_DECIMAL);
    }

    @Then("Status should return {int} Not Found")
    public void statusShouldReturnNotFound(int NotFound) {
        SerenityRest.then().statusCode(NotFound);
    }
}
