package suits;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import bean.action.HomePageAction;
import bean.action.LoginPageAction;
import hooks.DriverLoading;
import utils.jsonObject;

import static org.junit.Assert.assertTrue;

public class testsLogin {

    LoginPageAction loginPageAction = new LoginPageAction();
    HomePageAction homePageAction = new HomePageAction();
    JSONObject loginJson;

    @BeforeEach
    public void setUp() {
        DriverLoading.getDriver();
        loginJson = jsonObject.getJsonDataObject("mass", "LoginUser");
    }

    @AfterEach
    public void tearDown() {
        DriverLoading.closeDriver();
    }

    @Test
    public void loginSuccessful(){
        loginPageAction.inputDataLogin((String) loginJson.get("email"), (String) loginJson.get("password"));
        loginPageAction.clickButtonSubmit();
        homePageAction.checkTextWelcome();
    }

    @Test
    public void loginUnsuccessfulByEmail(){
        loginPageAction.inputDataLogin((String) loginJson.get("emailIncorrect"), (String) loginJson.get("password"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertEmailOrPasswordIncorrect());
    }

    @Test
    public void loginUnsuccessfulByPassword(){
        loginPageAction.inputDataLogin((String) loginJson.get("email"), (String) loginJson.get("passwordIncorrect"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertEmailOrPasswordIncorrect());
    }

    @Test
    public void loginUnsuccessfulByEmailAndPassword(){
        loginPageAction.inputDataLogin((String) loginJson.get("emailIncorrect"), (String) loginJson.get("passwordIncorrect"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertEmailOrPasswordIncorrect());
    }

    @Test
    public void loginUnsuccessfulByEmailEmpty(){
        loginPageAction.inputDataLogin((String) loginJson.get("emailEmpty"), (String) loginJson.get("password"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertEmailIsMandatory());
    }

    @Test
    public void loginUnsuccessfulByPasswordEmpty(){
        loginPageAction.inputDataLogin((String) loginJson.get("email"), (String) loginJson.get("passwordEmpty"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertPasswordIsMandatory());
    }

    @Test
    public void loginUnsuccessfulByEmailAndPasswordEmpty(){
        loginPageAction.inputDataLogin((String) loginJson.get("emailEmpty"), (String) loginJson.get("passwordEmpty"));
        loginPageAction.clickButtonSubmit();
        assertTrue(loginPageAction.alertEmailIsMandatory());
        assertTrue(loginPageAction.alertPasswordIsMandatory());
    }

}
