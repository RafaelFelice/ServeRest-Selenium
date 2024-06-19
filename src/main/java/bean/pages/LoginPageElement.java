package bean.pages;

import org.openqa.selenium.By;

public class LoginPageElement {

    //por que mapear os elementos com public final?
    //promover melhores práticas de desenvolvimento, como encapsulamento, imutabilidade e clareza do código. Isso contribui para um código mais robusto, fácil de manter e entender.

    public final By inputEmail = By.id("email");
    public final By inputPassword = By.id("password");
    public final By buttonEntrar = By.xpath("//button[text()='Entrar']");
    public final By linkCadastrar = By.linkText("Cadastre-se");
    public final  By txtEmailOrPasswordIncorrect = By.xpath("//span[text()='Email e/ou senha inválidos']");
    public final  By txtEmailIsMandatory = By.xpath("//span[text()='Email é obrigatório']");
    public final  By txtPasswordIsMandatory = By.xpath("//span[text()='Password é obrigatório']");

}
