package test.bean.action;

import test.bean.dsl.Commands;
import test.bean.pages.HomePageElement;

public class HomePageAction extends Commands {

    HomePageElement homePageElement = new HomePageElement();

    public void checkTextWelcome(){
        isVisible(homePageElement.txtWelcome);
    }
}
