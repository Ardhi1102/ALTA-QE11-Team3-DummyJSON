package starter.DummyJSON.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class CreateUsersApi {

    public static String URl = "https://dummyjson.com";
    public static final String DIR = System.getProperty("user.dir");
    public static String CREATE_USER = URl + "/users/add";
    public static String CREATE_USER_BODY_REQUEST = DIR +"/src/test/resources/JSON/JSONs/JSONBody";
    public static final String CREATE_USER_JSON_SCHEMA_VALIDATOR = DIR + "/src/test/resources/JSON/JSONs/JSONSchema";





    @Step("Create user body data")
    public void createUserBodyData (File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }






}
