package starter.DummyJSON.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.API.Utils.Constants;

import java.io.File;

public class CommentAPI {
    public static String GET_SINGLE_COMMENT = Constants.BASE_URL + "/comment/{id}";
    public static String POST_CREATE_COMMENT = Constants.BASE_URL + "/comment/add";
    public static String PUT_UPDATE_COMMENT = Constants.BASE_URL + "/comment/{id}";
    public static String DELETE_COMMENT = Constants.BASE_URL + "/comment/{id}";

    @Step("Get Single Comment")
    public void getSingleComment(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get Single Comment Invalid Param")
    public void getSingleCommentInvalidParam(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Post Create New Comment")
    public void postCreateComment(File json){
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update Comment")
    public void putUpdateComment(int id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Put Update Comment Invalid Id")
    public void putUpdateCommentInvalidId(String id, File json){
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Delete Comment")
    public void deleteComment(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete Comment Invalid Param")
    public void deleteCommentInvalidParam(String id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
