package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ClassNameUtil;
import utils.PropertyLoader;

public class LoginTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private final static String EMAIL = PropertyLoader.loadProperty("user.EMAIL");
    private final static String PASS = PropertyLoader.loadProperty("user.PASS");

    // all input correct
    @Test
    public void test1_positiveLogin() {

        log.info(String.format("test1_positiveLogin"));

        {

            ellos.homePage.closeBlurb();
            log.info(String.format("close blurb"));

            ellos.homePage.switchToRegistrationPage();
            log.info(String.format("switch to registration page"));

        }

        {

            ellos.loginPage.clickAndInputLoginField(EMAIL);
            log.info(String.format("click and input %s in login filed", EMAIL));

            ellos.loginPage.clickAndInputPassFieldWithTwoLocators(PASS);
            log.info(String.format("click and input %s in password field", PASS));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        ellos.homePage.clickLogoutLink();
        log.info(String.format("click on logout link"));

    }

    // input incorrect email and correct password
    @Test
    public void test2_incorrectLogin() {

        log.info(String.format("test2_incorrectLogin"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            String failedEMAIL = "qwerty" + EMAIL;

            ellos.loginPage.clickAndInputLoginFieldAndClickTAB(failedEMAIL);
            log.info(String.format("click and input %s in login field and click TAB", failedEMAIL));

            ellos.loginPage.clickAndInputPassFieldWithOneLocator(PASS);
            log.info(String.format("click and input %s in password filed", PASS));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        Assert.assertTrue(ellos.loginPage.isErrorMessagePresentOnPage(),
                "error message is present on page");

    }

    // input correct email and incorrect password
    @Test
    public void test3_incorrectPassField() {

        log.info(String.format("test3_incorrectPassField"));

        {

            ellos.loginPage.clickAndInputLoginFieldAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in login field and click TAB",
                    EMAIL));

            String failedPass = PASS.substring(0, 3);

            ellos.loginPage.clickAndInputPassFieldWithOneLocator(failedPass);
            log.info(String.format("click and input %s in password field", failedPass));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        Assert.assertTrue(ellos.loginPage.isErrorMessagePresentOnPage(),
                "error message is present on page");

    }

    // input empty email and password
    @Test
    public void test4_emptyEmailAndPassFields() {

        log.info(String.format("test4_emptyEmailAndPassFields"));

        {

            ellos.loginPage.clickAndInputLoginFieldAndClickTAB("");
            log.info(String.format("click and input empty in login field and click TAB"));

            ellos.loginPage.clickAndInputPassFieldWithOneLocator("");
            log.info(String.format("click and input empty in password field"));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        Assert.assertTrue(ellos.loginPage.isErrorMessageFieldsEmpty(),
                "error message is present on page");

    }

    // input empty email and correct password
    @Test
    public void test5_emptyEmailField() {

        log.info(String.format("test5_emptyEmailField"));

        {

            ellos.loginPage.clickAndInputLoginFieldAndClickTAB("");
            log.info(String.format("click and input empty in login field and click TAB"));

            ellos.loginPage.clickAndInputPassFieldWithOneLocator(PASS);
            log.info(String.format("click and input %s in password field", PASS));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        Assert.assertTrue(ellos.loginPage.isErrorMessageOneFieldEmpty(),
                "error message is present on page");

    }

    // input correct email and empty password
    @Test
    public void test6_emptyPassField() {

        log.info(String.format("test6_emptyPassField"));

        {

            ellos.loginPage.clickAndInputLoginFieldAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in login field and click TAB", EMAIL));

            ellos.loginPage.clickAndInputPassFieldWithOneLocator("");
            log.info(String.format("click and input empty in password field and click TAB"));

            ellos.loginPage.clickLoginButton();
            log.info(String.format("click on login button"));

        }

        Assert.assertTrue(ellos.loginPage.isErrorMessageOneFieldEmpty(),
                "error message is present on page");

    }

}
