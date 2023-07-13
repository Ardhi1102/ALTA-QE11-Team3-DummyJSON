package starter.DummyJSON.API;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constants;

import java.io.File;

public class CartsAPI {
    public static String GET_SINGLE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String GET_ALL_CARTS = Constants.BASE_URL + "/carts";
    public static String GET_ALL_INVALID_CARTS = Constants.BASE_URL + "/cartsusers";
    public static String GET_USER_CARTS = Constants.BASE_URL + "/carts/user/{id}";
    public static String POST_ADD_CARTS = Constants.BASE_URL + "/carts/add";
    public static String PUT_UPDATE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String PUT_BLANK_UPDATE_CARTS = Constants.BASE_URL + "/carts/";
    public static String DELETE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String DELETE_BLANK_CARTS = Constants.BASE_URL + "/carts/";



    @Step("Get Single Cart")
    public void getSingleCart(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get Single Cart with Invalid Parameter")
    public void getSingleCartInvalidParam(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get All Cart")
    public void getAllCart() {
        SerenityRest.given();
    }
    @Step("Get All Cart")
    public void getAllInvalidCart() {
        SerenityRest.given();
    }
    @Step("Get Cart User")
    public void getCartUser(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Get Cart User Invalid Parameter")
    public void getCartUserInvalidParameter(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Add New Cart")
    public void postAddNewCarts(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update Cart")
    public void putUpdateCarts(int id, File json) {
        SerenityRest.given()
                .pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);
    }
    @Step("Update Cart Blank Parameter")
    public void putUpdateCartsBlank() {
        SerenityRest.given();
    }
    @Step("Delete Cart")
    public void deleteCarts(int id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete Cart Invalid Param")
    public void deleteCartsInvalidParam(String id) {
        SerenityRest.given()
                .pathParam("id", id);
    }
    @Step("Delete Chart Blank Parameter")
    public void deleteCartsBlank() {
        SerenityRest.given();
    }
}
