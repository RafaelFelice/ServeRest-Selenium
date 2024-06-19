package bean.action;

import bean.dsl.Commands;
import bean.pages.LoginPageElement;

public class LoginPageAction extends Commands {

    LoginPageElement loginPageElement = new LoginPageElement();

    public void inputDataLogin(String email, String password){
        sendKeys(email, loginPageElement.inputEmail);
        sendKeys(password, loginPageElement.inputPassword);
    }

    public void clickButtonSubmit(){
        isVisible(loginPageElement.buttonEntrar);
        click(loginPageElement.buttonEntrar);
    }

    public boolean alertEmailOrPasswordIncorrect(){
        isVisible(loginPageElement.txtEmailOrPasswordIncorrect);
        return true;
    }

    public boolean alertEmailIsMandatory(){
        isVisible(loginPageElement.txtEmailIsMandatory);
        return true;
    }

    public boolean alertPasswordIsMandatory(){
        isVisible(loginPageElement.txtPasswordIsMandatory);
        return true;
    }

    public void clickLinkRegistrar(){
        isVisible(loginPageElement.linkCadastrar);
        click(loginPageElement.linkCadastrar);
    }

}

