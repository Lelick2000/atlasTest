package project.page.objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import project.models.User;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement usernameInput = $("#user-name");
    private final SelenideElement passwordInput = $("#password");
    private final SelenideElement submitButton = $("#login-button");


    public void loginUser(User user) {
        usernameInput.shouldBe(Condition.visible).setValue(user.getUsername());
        passwordInput.setValue(user.getPassword());
        submitButton.click();
    }
}
