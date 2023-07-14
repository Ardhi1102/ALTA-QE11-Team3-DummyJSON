package starter.DummyJSON.StepDef.Comment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CommentAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class CreateCommentStepDef {
    @Steps
    CommentAPI commentAPI;
    @Given("Post create new comment with valid json")
    public void postCreateNewCommentWithValidJson() {
        File json = new File(Constants.Comment_Body + "/CreateCommentValidBody.json");
        commentAPI.postCreateComment(json);
    }

    @When("Send request post create new comment with valid json")
    public void sendRequestPostCreateNewCommentWithValidJson() {
        SerenityRest.when()
                .post(CommentAPI.POST_CREATE_COMMENT);
    }

    @Given("Post create new comment with invalid json")
    public void postCreateNewCommentWithInvalidJson() {
        File json = new File(Constants.Comment_Body + "/CreateCommentInvalidBody.json");
        commentAPI.postCreateComment(json);
    }

    @When("Send request post create new comment with invalid json")
    public void sendRequestPostCreateNewCommentWithInvalidJson() {
        SerenityRest.when()
                .post(CommentAPI.POST_CREATE_COMMENT);
    }

    @And("Validate post create comment success json schema")
    public void validatePostCreateCommentSuccessJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/CreateCommentValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @And("Validate post create comment unsuccess json schema")
    public void validatePostCreateCommentUnsuccessJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/CreateCommentInvalid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }
}
