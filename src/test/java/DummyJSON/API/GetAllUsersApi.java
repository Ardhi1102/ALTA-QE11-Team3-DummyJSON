package DummyJSON.API;

import DummyJSON.Utils.ConstansJOSS;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;



    public class GetAllUsersApi {

        public static String GET_SINGLE_USER = ConstansJOSS.BASE_URL +"/users/{id}";
        @Step ("Get single user")
        public void getSingleUSer (int id) {SerenityRest.given()
                .pathParam("id", id);}

        public static String GET_SINGLE_INVALID_USER = ConstansJOSS.BASE_URL +"/users/{nilai}";
        @Step("Get single user with invalid id")
        public void getSingleUserWithinvalidId(String nilai){
            SerenityRest.given().pathParam("nilai",nilai);
        }
        public static String GET_SINGLE_INVALID_DECIMAL = ConstansJOSS.BASE_URL + "/users/{id}";
        @Step("Get single invalid decimal")
        public void getsingleinvaliddecimal(float id){
            SerenityRest.given().pathParam("id", id);
        }
        public static String GET_ALL_USERS = ConstansJOSS.BASE_URL + "/users";
        @Step("Get All Users")
        public void getallusers(){
            SerenityRest.given();
        }
        public static String GET_INVALID_PARAMALLUSERS =ConstansJOSS.BASE_URL + "/usersx";
        @Step("Get Invalid paramater all users")
        public void getinvalidparamaterallusers(){
            SerenityRest.given();
        }

    }


