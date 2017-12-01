package com.discover.test.search;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features="src/test/resources/features/search/search_directions.feature",
        glue="com.discover.test.search.steps"
)
public class SearchDirections { }
