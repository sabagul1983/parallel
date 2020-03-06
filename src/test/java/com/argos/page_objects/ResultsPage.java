package com.argos.page_objects;

import com.argos.drivers.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;

public class ResultsPage extends DriverManager {

    @FindBy(css = ".findability-facet__rating-label")
    private List<WebElement> ratingWebElements;

    @FindBy(css = "div[data-test='component-ratings']")
    private List<WebElement> ratingStars;

    @FindBy(css = "label[name='price']")
    private List<WebElement> priceRanges;

    @FindBy(css = "div[data-test='component-product-card']")
    private List<WebElement> itemsAvailableToAddToTrolley;

   /* @FindBy(css= "label[name='price']")
    private List<WebElement> priceFilters;*/

    public void selectReviewFilter(String filterOption){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".findability-facet__rating-label"),5));

        if (ratingWebElements.size() == 0) {
            fail("No ratings found");
        }
        for(WebElement reviewFilter : ratingWebElements){
            String availableFilter = reviewFilter.getText();
            if(availableFilter.equalsIgnoreCase(filterOption)){
                reviewFilter.click();
                break;
            }
        }
    }

    public void selectPriceFilter(String priceFilterOption){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("label[name='price']"),3));

        if (priceRanges.size() == 0) {
            fail("No price ranges found");
        }

        for(WebElement priceFilter : priceRanges){
            String availableFilter = priceFilter.getText();
            if(availableFilter.contains(priceFilterOption)){
                priceFilter.click();
                break;
            }
        }
    }

    public List<Double> getProductRating() throws InterruptedException {
       Thread.sleep(3000);
        // new WebDriverWait(driver, 10)
       //         .until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector("div[data-test='component-ratings']"), 5));

        if(ratingStars.size()==0){
            fail("No customer rating found");
        }

        List<Double> ratingList = new ArrayList<>();
        for(WebElement ratingElement: ratingStars){
            String ratingString = ratingElement.getAttribute("data-star-rating");
            Double ratingDouble = Double.parseDouble(ratingString);
            ratingList.add(ratingDouble);
        }
        return ratingList;
    }

    public void addToTrolley(){
        WebElement we = itemsAvailableToAddToTrolley.get(1);
    }
}
