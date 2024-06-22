package bean.action;

import bean.dsl.Commands;
import bean.pages.RegisterUserPageElement;
import com.github.javafaker.Faker;
import data.UserFaker;

public class RegisterUserPageAction extends Commands {

    RegisterUserPageElement registerUserPageElement = new RegisterUserPageElement();
    UserFaker userFaker = new UserFaker();

    public void generateDataUserFaker(){
        Faker fakeData = new Faker();
        userFaker.setFisrtName(fakeData.name().firstName());
        userFaker.setLastName(fakeData.name().lastName());
        userFaker.setEmail(fakeData.internet().emailAddress(
                userFaker.getFisrtName() + userFaker.getLastName().toLowerCase()));
        userFaker.setPassword(fakeData.internet().password());

        System.out.println("Generated User Data:");
        System.out.println("Full Name: " + userFaker.getFisrtName() + " " + userFaker.getLastName());
        System.out.println("Email: " + userFaker.getEmail());
        System.out.println("Password: " + userFaker.getPassword());

        sendKeys(userFaker.getFisrtName() + " " + userFaker.getLastName(), registerUserPageElement.inputName);
        sendKeys(userFaker.getEmail(), registerUserPageElement.inputEmail);
        sendKeys(userFaker.getPassword(), registerUserPageElement.inputPassword);
        click(registerUserPageElement.checkBoxAdmin);
    }

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
