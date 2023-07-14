package starter.DummyJSON.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CommentAPI;
import starter.DummyJSON.API.Utils.Constants;

import java.io.File;

public class UpdateCommentStepDef {
    @Steps
    CommentAPI commentAPI;
    @Given("Post update comment with valid json and valid id {}")
    public void postUpdateCommentWithValidJsonAndValidId(int id) {
        File json = new File(Constants.Comment_Body +"/UpdateCommentValidBody.json");
        commentAPI.putUpdateComment(id, json);
    }

    @When("Send request post update comment with valid json")
    public void sendRequestPostUpdateCommentWithValidJson() {
        SerenityRest.when()
                .put(CommentAPI.PUT_UPDATE_COMMENT);
    }

    @And("Validate update comment valid json schema")
    public void validateUpdateCommentValidJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/UpdateCommentValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Post update comment with valid json and invalid id {string}")
    public void postUpdateCommentWithValidJsonAndInvalidId(String id) {
        File json = new File(Constants.Comment_Body +"/UpdateCommentValidBody.json");
        commentAPI.putUpdateCommentInvalidId(id, json);
    }

    @When("Send request post update comment with invalid json")
    public void sendRequestPostUpdateCommentWithInvalidJson() {
        SerenityRest.when()
                .put(CommentAPI.PUT_UPDATE_COMMENT);
    }
}
