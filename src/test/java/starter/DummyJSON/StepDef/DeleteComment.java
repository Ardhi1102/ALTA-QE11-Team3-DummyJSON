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

public class DeleteComment {
    @Steps
    CommentAPI commentAPI;
    @Given("Delete comment with valid id {}")
    public void deleteCommentWithValidId(int id) {
        commentAPI.deleteComment(id);
    }

    @When("Send request delete comment with valid id")
    public void sendRequestDeleteCommentWithValidId() {
        SerenityRest.when()
                .delete(CommentAPI.DELETE_COMMENT);
    }

    @And("Validate delete comment json schema")
    public void validateDeleteCommentJsonSchema() {
        File json = new File(Constants.Comment_Schema + "/DeleteCommentValid.json");
        SerenityRest.and()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(json));
    }

    @Given("Delete comment with invalid id {string}")
    public void deleteCommentWithInvalidId(String id) {
        commentAPI.deleteCommentInvalidParam(id);
    }

    @When("Send request delete comment with invalid id")
    public void sendRequestDeleteCommentWithInvalidId() {
        SerenityRest.when()
                .delete(CommentAPI.DELETE_COMMENT);
    }
}
