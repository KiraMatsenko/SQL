package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    SelenideElement codeField = $("[data-test-id=code]");
    SelenideElement verifyButton = $("[data-test-id=action-verify]");
    SelenideElement verificationErrorNotification = $("[data-test-id=error-notification]");

    public void verifyVerificationPageVisibility() {
        verificationErrorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}

