package starter.StepDef.UserStepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.UsersAPI.GetAllUsersApi;
import starter.DummyJSONResponses.UsersResponse;
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
}
