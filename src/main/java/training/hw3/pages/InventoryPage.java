package training.hw3.pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import training.hw3.base.Base;

import java.util.*;

public class InventoryPage extends Base {
    private final String TXT_PRODUCT_NAME="//div[@class='inventory_item_name']";

    private final String TXT_CARD="//span[@class='shopping_cart_badge']";
    private final String BTN_CARD="//div[@id='shopping_cart_container']";

    private final String CARD_ITEMS="//div[@class='inventory_item_name']";

    List<String> names=new ArrayList<>();
    List<String> randomNames=new ArrayList<>();

    public void getName(){
        List<WebElement> products=action.findElements(TXT_PRODUCT_NAME);
        for(int i=0;i<products.size();i++){
            String name=products.get(i).getText().trim();
            names.add(name);
        }
        System.out.println(names);
        System.out.println(names.size());
    }

    public void random(){
        int randomNumbers = 2;
        Random num = new Random();
        for ( int i=0; i<randomNumbers; i++ )
        {
            int randomNum = num.nextInt(names.size());
            if(randomNames.isEmpty()){
                randomNames.add(names.get(randomNum));
            }else{
                if(!randomNames.contains(names.get(randomNum))){
                    randomNames.add(names.get(randomNum));
                }
            }
        }
    }
    public void addCart(){
        for(String element:randomNames){
            action.click("//div[contains(text(),'"+element+"')]//ancestor::div[1]/following-sibling::div/button");
        }
    }

    public void addCartSuccessfully(){
        String amount=action.getText(TXT_CARD);
        action.verify(amount,"2");
        for(String element:randomNames){
            String buttonName=action.getText("//div[contains(text(),'"+element+"')]//ancestor::div[1]/following-sibling::div/button");
            action.verify(buttonName.toLowerCase(),"remove");
        }
    }

    public void clickCart(){
        action.click(BTN_CARD);
    }

    public void clickCartSuccessfully(){
        String currentUrl= action.getCurrentUrl();
        action.verify(url+"cart.html",currentUrl);
        List<WebElement> list=action.findElements(CARD_ITEMS);
        Assert.assertTrue(randomNames.contains(list.get(0).getText().trim()),"actual: "+list.get(0).getText().toLowerCase()+"expected: "+randomNames);
        Assert.assertTrue(randomNames.contains(list.get(1).getText().trim()),"actual: "+list.get(0).getText().toLowerCase()+"expected: "+randomNames);
    }



}
