package suits;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import bean.action.HomePageAction;
import bean.action.LoginPageAction;
import bean.action.RegisterUserPageAction;
import hooks.DriverLoading;
import utils.jsonObject;

public class testsRegisterUser {

    LoginPageAction loginPageAction = new LoginPageAction();
    RegisterUserPageAction registerUserPageAction = new RegisterUserPageAction();
    HomePageAction homePageAction = new HomePageAction();
    JSONObject registerJson;

    @BeforeEach
    public void setUp() {
        DriverLoading.getDriver();
        registerJson = jsonObject.getJsonDataObject("mass", "RegisterUser");
    }

    @AfterEach
    public void tearDown() {
        DriverLoading.closeDriver();
    }

    @Test
    public void registerUserSuccessful(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("name"),
                (String) registerJson.get("email"),
                (String) registerJson.get("password"));
        registerUserPageAction.clickButtonRegister();
        homePageAction.checkTextWelcome();
    }

    @Test
    public void registerUserUnsuccessfulByEmailUsed(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("name"),
                (String) registerJson.get("emailUsed"),
                (String) registerJson.get("password"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertEmailUsed();
    }

    @Test
    public void registerUserUnsuccessfulByNameEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("nameEmpty"),
                (String) registerJson.get("email"),
                (String) registerJson.get("password"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertNameIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByEmailEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("name"),
                (String) registerJson.get("emailEmpty"),
                (String) registerJson.get("password"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertEmailIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByPasswordEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("name"),
                (String) registerJson.get("email"),
                (String) registerJson.get("passwordEmpty"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertPasswordIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByNameAndEmailEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("nameEmpty"),
                (String) registerJson.get("emailEmpty"),
                (String) registerJson.get("password"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertNameIsMandatory();
        registerUserPageAction.alertEmailIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByNameAndPasswordEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("nameEmpty"),
                (String) registerJson.get("email"),
                (String) registerJson.get("passwordEmpty"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertNameIsMandatory();
        registerUserPageAction.alertPasswordIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByEmailAndPasswordEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("name"),
                (String) registerJson.get("emailEmpty"),
                (String) registerJson.get("passwordEmpty"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertEmailIsMandatory();
        registerUserPageAction.alertPasswordIsMandatory();
    }

    @Test
    public void registerUserUnsuccessfulByDataEmpty(){
        loginPageAction.clickLinkRegistrar();
        registerUserPageAction.inputDataRegisterUser(
                (String) registerJson.get("nameEmpty"),
                (String) registerJson.get("emailEmpty"),
                (String) registerJson.get("passwordEmpty"));
        registerUserPageAction.clickButtonRegister();
        registerUserPageAction.alertNameIsMandatory();
        registerUserPageAction.alertEmailIsMandatory();
        registerUserPageAction.alertPasswordIsMandatory();
    }
}
