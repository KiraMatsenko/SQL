import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class LoginFormTest {

    @AfterAll
    static void tearDown(){
        cleanDatabase();
    }

    @Test
    public void shouldLoginCorrectUser() {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var authInfo = DataHelper.getCorrectAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.geVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    public void shouldErrorIncorrectUser() {
        var loginPage = open("http://localhost:9999/", LoginPage.class);
        var authInfo = DataHelper.generateRandomUser();
        loginPage.validLogin(authInfo);
        loginPage.VerifyErrorNotificationVisibility();
    }
}
