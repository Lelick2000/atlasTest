package project.actions.ui.steps;

import net.thucydides.core.annotations.Step;
import project.models.User;
import project.page.objects.LoginPage;

public class LoginPageSteps {
    private final LoginPage loginPage = new LoginPage();

    @Step("Login existing user ")
    public void loginUser(User user) {
        loginPage.loginUser(user);
    }
}
