package com.argos.step_definitions;

import com.argos.page_objects.ResultsPage;
import com.argos.page_objects.TrolleyPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.argos.page_objects.HomePage;
import cucumber.api.java.en.Given;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;


import java.util.List;

import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.junit.Assert.assertTrue;

public class FilterSteps {

    private ResultsPage resultsPage = new ResultsPage();


    @When("^I apply filter review \"([^\"]*)\"$")
    public void i_apply_filter_review(String filterOption) {
        resultsPage.selectReviewFilter(filterOption);
    }

    @Then("^I should be able to see product rating \"([^\"]*)\"$")
    public void i_should_be_able_to_see_product_rating(double expectedRating) throws InterruptedException {
        List<Double> actualRating = resultsPage.getProductRating();
            assertThat(actualRating, everyItem(is(greaterThanOrEqualTo(expectedRating))));

    }

    @When("^I apply price review \"([^\"]*)\"$")
    public void i_apply_price_review(String priceRange) {
        //some filter by price logic here
        resultsPage.selectPriceFilter(priceRange);
    }

    @Then("^I should be able to see products in price range$")
    public void i_should_be_able_to_see_products_in_price_range() {


    }

}
