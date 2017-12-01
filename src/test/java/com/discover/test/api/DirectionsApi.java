package com.discover.test.api;

import com.discover.test.config.Config;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import static org.hamcrest.CoreMatchers.equalTo;

public class DirectionsApi {
    private Response response = null;

    public void getDirections(String origin, String destination) {
        response = SerenityRest.given().log().all()
            .queryParam("origin", origin)
            .queryParam("destination", destination)
            .queryParam("mode", "driving")
            .queryParam("key", Config.getApiKey())
        .when()
            .get("https://maps.googleapis.com/maps/api/directions/json");
    }

    public void responseShouldBeOk() {
        response.then().statusCode(200).body("status" , equalTo("OK"));
    }

    public String getDistance() {
        return response.body().jsonPath().get("routes[0].legs[0].distance.text").toString().replace("miles", "mi");
    }

    public String getDuration() {
        return response.body().jsonPath().get("routes[0].legs[0].duration.text").toString().replace("mins", "min");
    }
}
