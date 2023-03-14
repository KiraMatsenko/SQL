package pages;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement loginField = $("[data-test-id=login] input");
    SelenideElement passwordField = $("[data-test-id=password] input");
    SelenideElement loginButton = $("[data-test-id=action-login]");
    SelenideElement loginErrorNotification = $("[data-test-id=error-notification]");

    public void verifyErrorNotificationVisibility() {
        loginErrorNotification.shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
}
