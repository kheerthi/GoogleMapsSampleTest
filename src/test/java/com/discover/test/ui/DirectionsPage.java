package com.discover.test.ui;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.http.client.utils.URIBuilder;

public class DirectionsPage extends PageObject {
    @FindBy(id="section-directions-trip-0")
    WebElementFacade firstResult;

    public void getDirections(String origin, String dest) {
        getDriver().get(getUrl(origin, dest));
    }

    public String getDistance() {
        return firstResult.getText().split("\n")[1].replace("miles", "mi");
        ReportPortal.emitLog("My message::getDistance", "INFO", Calendar.getInstance().getTime());
    }

    public String getDuration() {
        return firstResult.getText().split("\n")[0].replace("mins", "min");
        ReportPortal.emitLog("My message::getDuration", "INFO", Calendar.getInstance().getTime());
    }

    private String getUrl(String origin, String dest) {
        try {
            URIBuilder ub = new URIBuilder("https://www.google.com/");
            ub.setPath("maps/dir/" + origin + "/" + dest);
            return ub.toString();
        } catch (Exception e) {}

        return null;
    }
}
