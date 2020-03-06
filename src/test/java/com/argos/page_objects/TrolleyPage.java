package com.argos.page_objects;

import com.argos.drivers.DriverManager;
import com.argos.utilites.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TrolleyPage extends DriverManager {

    Helper helper = new Helper();

    @FindBy (css="[class='xs-12--none md-6--none lg-5--none undefined'] [placeholder='Enter postcode or town']")
    private WebElement searchPostCodeTextBox;

    @FindBy (css = "div[class='xs-hidden sm-hidden md-block lg-block Basket__maxHeight__DpQL8'] button[id='basket-FulfilmentSelectorForm-collectButton']")
    private WebElement collectionButton;

    @FindBy (css = "button[class='ac-ss-availability-result__button ac-ss-availability-result__button--wide button button--quarter button--tiny button--secondary']")
        private List<WebElement> selectStoreButtonList;

    @FindBy (css = "[data-e2e='continue-with-collection-button']")
    private WebElement continueWithCollectionButton;

    @FindBy (css = "button[data-test='component-att-button']")
    private WebElement addToTrolleyButton;

    @FindBy (css = ".xs-row a[data-test='component-att-button-basket']")
    private WebElement goToTrollyButton;

    @FindBy (css = "select[class='ProductCard__quantitySelect__2y1R3']")
    private WebElement quantityButton;

    @FindBy (css = "div[class='Summary__subTotalLabel__2GphY']")
    private WebElement priceAfterChange;

    @FindBy (css = "[class='ProductCard__content__9U9b1 xsHidden lgFlex'] [class='ProductCard__titleLink__1PgaZ']")
    private List<WebElement> boughtItems;

    @FindBy (css = "span[class='ProductCard__productLinePrice__3QC7V']")
    private WebElement priceWebelement;

    //collect items found in list
    @FindBy (css = "a[class='ProductCardstyles__Title-l8f8q8-12 dItzfm']")
    private List<WebElement> searchedItems;


    public void addToTrolley() {
        addToTrolleyButton.click();
    }

    public void addRandomItemToTrolley(){

    }

    public void goToTrolley() {
        goToTrollyButton.click();
    }

    public void changeQuantityTo(String quantity) {
        Select s = new Select(quantityButton);
        s.selectByVisibleText(quantity);
        System.out.println("quantity changed to " + quantity);

    }

    public double seeTotalPrice() throws InterruptedException {
        Thread.sleep(2000);
        String priceStringAfterChange = priceAfterChange.getText();
        System.out.println("price is " + priceStringAfterChange);
        String priceTrimmedAfterChange = priceStringAfterChange.substring(1);
        System.out.println(priceTrimmedAfterChange);
        Double priceAfterChange = Double.parseDouble(priceTrimmedAfterChange);
        System.out.println(priceAfterChange);
        return priceAfterChange;
    }

    public void checkTotalItems(String newQuantity){
        sleep(3000);
        int newQuantityInt = Integer.parseInt(newQuantity);

    }

    public double checkItemPriceInTrolley(){
        //check price of item in trolley and store it
        String priceString = priceWebelement.getText();
        System.out.println("price is " + priceString);
        String priceTrimmed = priceString.substring(1);
        System.out.println(priceTrimmed);
        Double price = Double.parseDouble(priceTrimmed);
        System.out.println(price);
        return price;
    }

    public void enterPostcode(String postCd){
        searchPostCodeTextBox.sendKeys(postCd);
    }

    public void clickCollectionButton(){
        collectionButton.click();
    }

    public void selectAStore(){
        /*for(WebElement b : selectStoreButtonList){
            b.click();
            break;
        }*/

       int selectItemNumber = helper.generateRandomNumber(5);
        selectStoreButtonList.get(selectItemNumber).click();
    }

    public void clickContinueWithCollectionButton() throws InterruptedException {
        Thread.sleep(1500);
        continueWithCollectionButton.click();
    }

    public void addChoosenItem(String item){
        for (int i = 0; i < searchedItems.size(); i++
        ) {
            if (searchedItems.get(i).getText().equals(item)) {
                System.out.println(searchedItems.get(i).getText());
                driver.findElements(By.cssSelector("button[class='Buttonstyles__Button-q93iwm-2 dolwDx btn-cta']")).get(i).click();
                System.out.println("item added to trolly");
                break;
            }
        }
    }
}
