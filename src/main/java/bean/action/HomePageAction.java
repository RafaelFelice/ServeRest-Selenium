package bean.action;

import bean.dsl.Commands;
import bean.pages.HomePageElement;

public class HomePageAction extends Commands {

    HomePageElement homePageElement = new HomePageElement();

    public void checkTextWelcome(){
        isVisible(homePageElement.txtWelcome);
    }
}
