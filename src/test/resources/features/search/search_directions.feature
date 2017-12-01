Feature: Searching for directions

  Search for directions and compare output from API with UI

  Scenario Outline: Search between cities
    When calling search API for directions from '<origin>' to '<destination>'
    And calling maps UI for directions from '<origin>' to '<destination>'
    Then distance should match between UI and API
    And duration should match between UI and API

    Examples:
    | origin | destination |
    | San Francisco, CA 94102 | San Francisco, CA 94104 |
#    | New York, NY 10037 | New York, NY 10036 |