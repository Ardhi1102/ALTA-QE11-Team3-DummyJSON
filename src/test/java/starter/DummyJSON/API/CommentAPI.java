package starter.DummyJSON.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.API.Utils.Constants;

import java.io.File;

public class CommentAPI {
    public static String GET_SINGLE_COMMENT = Constants.BASE_URL + "/comment/{id}";
    @Step("Get Single Comment")
    public void getSingleComment(int id){
        SerenityRest.given()
                .pathParam("id", id);
    }
}
