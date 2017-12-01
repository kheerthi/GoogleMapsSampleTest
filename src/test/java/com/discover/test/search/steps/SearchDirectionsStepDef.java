package com.discover.test.search.steps;

import com.discover.test.api.DirectionsApi;
import com.discover.test.ui.DirectionsPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchDirectionsStepDef {
    @Steps
    DirectionsApi directionsApi;

    DirectionsPage directionsPage;

    @When("^calling search API for directions from '(.*)' to '(.*)'$")
    public void callingSearchAPIForDirectionsFromOriginToDest(String origin, String dest) {
        System.out.println("Source: " + origin + ", dest: " + dest);
        System.out.println("\n~~~~~~~~~~~~~~\nAPI\n~~~~~~~~~~~~~~");
        directionsApi.getDirections(origin, dest);
        directionsApi.responseShouldBeOk();

        System.out.println("API - First directions result duration: " + directionsApi.getDuration());
        System.out.println("API - First directions result distance: " + directionsApi.getDistance());
    }

    @When("^calling maps UI for directions from '(.*)' to '(.*)'$")
    public void callingUIForDirectionsFromOriginToDest(String origin, String dest) {
        System.out.println("\n~~~~~~~~~~~~~~\nUI\n~~~~~~~~~~~~~~");
        directionsPage.getDirections(origin, dest);
        System.out.println("UI - First directions result duration: " + directionsPage.getDuration());
        System.out.println("UI - First directions result distance: " + directionsPage.getDistance());
    }

    @Then("^distance should match between UI and API$")
    public void distanceShouldMatchBetweenUIAndAPI() throws Throwable {
        System.out.println("\n~~~~~~~~~~~~~~\nDistance Match\n~~~~~~~~~~~~~~");
        assertThat(directionsApi.getDistance()).isEqualToIgnoringCase(directionsPage.getDistance());
    }

    @Then("^duration should match between UI and API$")
    public void durationShouldMatchBetweenUIAndAPI() throws Throwable {
        System.out.println("\n~~~~~~~~~~~~~~\nDuration Match\n~~~~~~~~~~~~~~");
        assertThat(directionsApi.getDuration()).isEqualToIgnoringCase(directionsPage.getDuration());
    }
}
