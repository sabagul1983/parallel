package com.argos.step_definitions;

import com.argos.page_objects.TrolleyPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TrolleySteps {
    private TrolleyPage trolleyPage = new TrolleyPage();

    @When("^I add an item to trolley$")
    public void i_add_an_item_to_trolley() throws InterruptedException {
        Thread.sleep(2000);
        trolleyPage.addToTrolley();
    }

    @Then("^I should be able to see product in trolley$")
    public void i_should_be_able_to_see_product_in_trolley() {
        trolleyPage.goToTrolley();

    }

    @And("^I should be able to change quantity to \"([^\"]*)\"$")
    public void iShouldBeAbleToChangeQuantityTo(String newQuantity) {
        trolleyPage.changeQuantityTo(newQuantity);
    }

    @And("^I should be able to see total price$")
    public void iShouldBeAbleToSeeTotalPrice() throws InterruptedException {
        trolleyPage.seeTotalPrice();

    }

    @And("^I should be able to see total price in trolley$")
    public void iShouldBeAbleToSeeTotalPriceInTrolley() {
        trolleyPage.checkItemPriceInTrolley();
    }

    @And("^I should be able to enter postocode\"([^\"]*)\" in search$")
    public void iShouldBeAbleToEnterPostocodeInSearch(String postCode) {
        trolleyPage.enterPostcode(postCode);
        trolleyPage.clickCollectionButton();
    }

    @And("^I select a store of my choice$")
    public void iSelectAStoreOfMyChoice() {

    trolleyPage.selectAStore();
    }

    @And("^I continue with collection$")
    public void iContinueWithCollection() throws InterruptedException {
        Thread.sleep(1500);
        trolleyPage.clickContinueWithCollectionButton();
    }


    @And("^I add an item \"([^\"]*)\" to trolley$")
    public void iAddAnItemToTrolley(String item) {

        trolleyPage.addChoosenItem(item);

    }
}
