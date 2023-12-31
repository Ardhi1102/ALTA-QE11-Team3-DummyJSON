package starter.DummyJSON.StepDef.Comment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.DummyJSON.API.CommentAPI;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class SingleCommentStepDef {
    @Steps
    CommentAPI commentAPI;
    @Given("Get single comment with valid parameter id {}")
    public void getSingleCommentWithValidParameterId(int id) {
        commentAPI.getSingleComment(id);
    }

    @When("Send request get single comment with valid parameter id")
    public void sendRequestGetSingleCommentWithValidParameterId() {
        SerenityRest.when()
                .get(CommentAPI.GET_SINGLE_COMMENT);
    }

    @And("Validate get single comment valid parameter json schema")
    public void validateSingleCommentValidParameterJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/SingleCommentValidParam.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Get single comment with invalid parameter id {string}")
    public void getSingleCommentWithInvalidParameterId(String id) {
        commentAPI.getSingleCommentInvalidParam(id);
    }

    @When("Send request get single comment with invalid parameter id")
    public void sendRequestGetSingleCommentWithInvalidParameterId() {
        SerenityRest.when()
                .get(CommentAPI.GET_SINGLE_COMMENT);
    }

    @Given("Get single comment with exceed parameter id {}")
    public void getSingleCommentWithExceedParameterId(int id) {
        commentAPI.getSingleComment(id);
    }

    @And("Validate get single comment exceed parameter json schema")
    public void validateSingleCommentExceedParameterJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/SingleCommentExceedParam.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @When("Send request get single comment with exceed parameter id")
    public void sendRequestGetSingleCommentWithExceedParameterId() {
        SerenityRest.when()
                .get(CommentAPI.GET_SINGLE_COMMENT);
    }
}
