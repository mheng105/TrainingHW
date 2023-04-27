package training.hw3.pages;

import training.hw3.base.Base;


public class CartPage extends Base {

    private final String BTN_CHECKOUT="//button[@id='checkout']";

    public void clickCheckout(){
        action.click(BTN_CHECKOUT);
        String currentUrl=action.getCurrentUrl();
        action.verify(url+"checkout-step-one.html",currentUrl);
    }
}
