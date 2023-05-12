package training.hw3.pages;

import training.hw3.base.Base;

public class CheckoutPage extends Base {
    private final String TXT_FIRSTNAME="//input[@id='first-name']";
    private final String TXT_LASTNAME="//input[@id='last-name']";
    private final String TXT_CODE="//input[@id='postal-code']";
    private final String BTN_CONTINUE="//input[@id='continue']";
    private final String BTN_FINISH="//button[@id='finish']";

    private final String BTN_BACK="//button[@id='back-to-products']";


    public void fill(){
        action.sendKey(TXT_FIRSTNAME,"Hang");
        action.sendKey(TXT_LASTNAME,"DO");
        action.sendKey(TXT_CODE,"123");
    }

    public void clickContinue(){
        action.click(BTN_CONTINUE);
        String currentUrl=action.getCurrentUrl();
        action.verify(url+"checkout-step-two.html",currentUrl);
    }

    public void clickFinish(){
        action.click(BTN_FINISH);
        String currentUrl=action.getCurrentUrl();
        action.verify(url+"checkout-complete.html",currentUrl);
    }

    public void clickBack(){
        action.click(BTN_BACK);
        String currentUrl=action.getCurrentUrl();
        action.verify(url+"inventory.html",currentUrl);
    }

}
