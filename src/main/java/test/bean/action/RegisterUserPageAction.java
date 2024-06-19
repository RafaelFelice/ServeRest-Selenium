package test.bean.action;

import test.bean.dsl.Commands;
import test.bean.pages.RegisterUserPageElement;

public class RegisterUserPageAction extends Commands {

    RegisterUserPageElement registerUserPageElement = new RegisterUserPageElement();

    public void inputDataRegisterUser(String name, String email, String password){
        sendKeys(name, registerUserPageElement.inputName);
        sendKeys(email, registerUserPageElement.inputEmail);
        sendKeys(password, registerUserPageElement.inputPassword);
        click(registerUserPageElement.checkBoxAdmin);
        }

    public void clickButtonRegister(){
        isVisible(registerUserPageElement.buttonCadastrar);
        click(registerUserPageElement.buttonCadastrar);
    }

    public boolean alertEmailUsed(){
        isVisible(registerUserPageElement.txtEmailUsed);
        return true;
    }

    public boolean alertNameIsMandatory(){
        isVisible(registerUserPageElement.txtNameIsMandatory);
        return true;
    }
    public boolean alertEmailIsMandatory(){
        isVisible(registerUserPageElement.txtEmailIsMandatory);
        return true;
    }

    public boolean alertPasswordIsMandatory(){
        isVisible(registerUserPageElement.txtPasswordIsMandatory);
        return true;
    }
}
