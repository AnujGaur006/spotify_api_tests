package org.global;

import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.global.Route.API;
import static org.global.Route.TOKEN;

public class ReusableApiMethods {

    public static Response post(String path, String token, Object requestPayload){
      return given(SpecBuilder.getRequestSpec())
                .body(requestPayload)
                .auth().oauth2(token)
                .when()
                    .post(path)
                .then().spec(SpecBuilder.getResponseSpec())
                .assertThat()
                .extract().response();
    }

    public static Response get(String path, String token){
        return given(SpecBuilder.getRequestSpec())
                .auth().oauth2(token)
                .when()
                    .get(path)
                .then()
                .spec(SpecBuilder.getResponseSpec())
                .extract().response();
    }

    public static Response put(String path,String token, Object updatedObj){
        return given(SpecBuilder.getRequestSpec())
                .auth().oauth2(token)
                .body(updatedObj)
                .when()
                .put(path)
                .then().spec(SpecBuilder.getResponseSpec())
                    .extract().response();
    }

    public static Response postRefresh(HashMap<String,String> formParam){
        return given(SpecBuilder.getAccountRequestSpec())
                .formParams(formParam)
                .when()
                    .post(API + TOKEN)
                .then().spec(SpecBuilder.getResponseSpec())
                    .extract().response();
    }
}
