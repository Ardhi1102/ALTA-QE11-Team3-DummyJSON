package starter.DummyJSON.API;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.DummyJSON.Utils.Constants;

public class CartsAPI {
    public static String GET_SINGLE_CARTS = Constants.BASE_URL + "/carts/{id}";
    public static String GET_ALL_CARTS = Constants.BASE_URL + "/carts";
    public static String GET_ALL_INVALID_CARTS = Constants.BASE_URL + "/cartsusers";


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
}
