package pages;

import framework.base.BasePage;
import framework.elements.Button;
import framework.elements.TextField;
import framework.utils.LoadProperty;
import org.openqa.selenium.By;

public class AuthorizePage extends BasePage {
    private static TextField userLogin = new TextField(By.xpath("//input[contains(@placeholder,'e-mail')]"),
            "LogIn field");
    private static TextField userPassword = new TextField(By.xpath("//input[@type='password']"),
            "password Field");
    private static Button loginButton = new Button(By.xpath("//button[contains(@class,'auth-button')]"),
            "loginButton");
    private static String userLoginFromFile = LoadProperty.getXml("Login", 0);
    private static String userLoginFromFilePassword = LoadProperty.getXml("Password", 0);

    public AuthorizePage() {
        super(userLogin, userLoginFromFile);
    }

    public void sendAuthorizeText() {
        userLogin.waitAndClick();
        userLogin.sendText(userLoginFromFile);
        userPassword.waitAndClick();
        userPassword.sendText(userLoginFromFilePassword);
    }

    public void clickAutorizeButton() {
        loginButton.waitAndClick();
    }

    public void clickSubmitButton() {
        loginButton.waitAndClick();
    }
}
