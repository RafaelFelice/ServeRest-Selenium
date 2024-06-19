package test.bean.pages;

import org.openqa.selenium.By;

public class RegisterUserPageElement {

    public final By inputName = By.id("nome");
    public final By inputEmail = By.id("email");
    public final By inputPassword = By.id("password");
    public final By checkBoxAdmin = By.id("administrador");
    public final By buttonCadastrar = By.xpath("//button");
    public final By txtEmailUsed = By.xpath("//span[text()='Este email já está sendo usado']");
    public final  By txtNameIsMandatory = By.xpath("//span[text()='Nome é obrigatório']");
    public final  By txtEmailIsMandatory = By.xpath("//span[text()='Email é obrigatório']");
    public final  By txtPasswordIsMandatory = By.xpath("//span[text()='Password é obrigatório']");
}
