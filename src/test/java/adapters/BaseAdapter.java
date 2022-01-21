package adapters;

import com.google.gson.Gson;
import utils.PropertyReader;

import static io.restassured.RestAssured.given;

public abstract class BaseAdapter {

    Gson gson = new Gson();
    final String BASE_URL = "https://api.qase.io/v1/";
    final String AUTH_TOKEN = System.getenv().getOrDefault("TOKEN",PropertyReader.getProperty("qase.token"));


    public String get(String uri, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                when().
                        get(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }

    public String post(String uri, String requestBody, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                        body(requestBody).
                when().
                        log().all().
                        post(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }

    public String delete(String uri, String requestBody, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                        body(requestBody).
                 when().
                        log().all().
                        delete(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }

    public String patch(String uri, String requestBody, int expectedCode) {
        return
                given().
                        header("Token", AUTH_TOKEN).
                        header("Accept", "application/json").
                        header("Content-Type", "application/json").
                        body(requestBody).
                when().
                        log().all().
                        patch(BASE_URL + uri).
                then().
                        log().all().
                        statusCode(expectedCode).extract().body().asString();
    }
}
