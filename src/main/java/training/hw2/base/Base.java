package training.hw2.base;


import training.hw2.utils.webkeywords.WebUI;

public abstract class Base {
    protected WebUI action=new WebUI();
    public abstract void openBrowser();
    public abstract void closeBrowser();


}
