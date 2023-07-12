package starter.DummyJSON.API.UsersAPI;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;



    public class GetAllUsersApi {

        public static String URl = "https://dummyjson.com";
        public static final String DIR = System.getProperty("user.dir");

        public static String GET_SINGLE_USER = URl +"/users/{id}";
        @Step ("Get single user")
        public void getSingleUSer (int id) {SerenityRest.given()
                .pathParam("id", id);}




    }


