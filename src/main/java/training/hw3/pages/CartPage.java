package training.hw3.pages;

import io.qameta.allure.Step;
import training.hw3.base.Base;


public class CartPage extends Base {

    private final String BTN_CHECKOUT="//button[@id='checkout']";

    @Step("Clicked checkout button and navigated to url successfully")
    public void clickCheckout(){
        action.click(BTN_CHECKOUT);
        String currentUrl=action.getCurrentUrl();
        action.verify(url+"checkout-step-one.html",currentUrl);
    }
}
