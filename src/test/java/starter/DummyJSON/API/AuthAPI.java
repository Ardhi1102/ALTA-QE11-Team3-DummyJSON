package starter.DummyJSON.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class AuthAPI {
    public static String POST_LOGIN = Constants.BASE_URL + "/Auth/Login";
    @Step ("Post login with valid JSON")
    public void postLogin(File json){
        SerenityRest.given().contentType(ContentType.JSON).body(json);
    }

}
