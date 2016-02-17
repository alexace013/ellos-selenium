package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ClassNameUtil;
import utils.PropertyLoader;

import java.util.Random;

public class RegistrationTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String PASS = PropertyLoader.loadProperty("user.new.PASS");
    private static final String EMAIL = PropertyLoader.loadProperty("user.new.EMAIL"+ new Random().nextInt());
//    private static final String EMAIL = RandomUser.randomEmail();

    // all fields are filled in correctly
    @Test(priority = 1)
    public void test1_positiveRegistration() {

        log.info(String.format("\ntest1_positiveRegistration\n"));

        {

            ellos.homePage.closeBlurb();
            ellos.homePage.clickLoginLink();

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            //getRegistrationPage().clickAndInputPassRepeat(PASS);
            ellos.registrationPage.clickAndInputPassRepeatTest(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isRegistrationSuccessful(),
                "registration is successful");
//        getHomePage().clickLogoutLink();
//        log.info(String.format("click logout link"));
        // TODO Felaktig erbjudandekod what is this? (#offerCodeError)

    }

    // just first field is filled with an email
    @Test(priority = 2)
    public void test2_negativeOnlyFirstEmailField() {

        log.info(String.format("\ntest2_negativeOnlyFirstEmailField\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in email field repeat and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in password field and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassRepeat(emptyStr);
            log.info(String.format("click and input %s password field repeat", emptyStr));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just second field is filled with an email
    @Test(priority = 2)
    public void test3_negativeOnlySecondEmailField() {

        log.info(String.format("\ntest3_negativeOnlySecondEmailField\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {
            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailMain(emptyStr);
            log.info(String.format("click and input %s in email field", emptyStr));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in password field and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassRepeat(emptyStr);
            log.info(String.format("click and input %s password field repeat", emptyStr));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just first field is filled with an password
    @Test(priority = 2)
    public void test4_negativeOnlyFirstPassField() {

        log.info(String.format("\ntest4_negativeOnlyFirstPassField\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        String emptyStr = "";

        {

            ellos.registrationPage.clickAndInputEmailMain(emptyStr);
            log.info(String.format("click and input %s in email field", emptyStr));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in email field repeat and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(emptyStr);
            log.info(String.format("click and input %s password field repeat", emptyStr));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just second field is filled with an password
    @Test(priority = 2)
    public void test5_negativeOnlySecondPassField() {

        log.info(String.format("\ntest5_negativeOnlySecondPassField\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailMain(emptyStr);
            log.info(String.format("click and input %s in email field", emptyStr));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in email field repeat and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in password field and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // only an email fields filled
    @Test(priority = 2)
    public void test6_negativeOnlyEmailFields() {

        log.info(String.format("\ntest6_negativeOnlyEmailFields\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            String emptyStr = "";

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in password field and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassRepeat(emptyStr);
            log.info(String.format("click and input %s password field repeat", emptyStr));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // only an password fields filled
    @Test(priority = 2)
    public void test7_negativeOnlyPassFields() {

        log.info(String.format("\ntest7_negativeOnlyPassFields\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailMain(emptyStr);
            log.info(String.format("click and input %s in email field", emptyStr));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in email field repeat and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // first password field is empty
    @Test(priority = 2)
    public void test8_negativeFirstPassFieldEmpty() {

        log.info(String.format("\ntest8_negativeFirstPassFieldEmpty\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            String emptyStr = "";

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in password field and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // second password field is empty
    @Test(priority = 2)
    public void test9_negativeSecondPassFieldEmpty() {

        log.info(String.format("\ntest9_negativeSecondPassFieldEmpty\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            String emptyStr = "";

            ellos.registrationPage.clickAndInputPassRepeat(emptyStr);
            log.info(String.format("click and input %s password field repeat", emptyStr));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // first email field empty
    @Test(priority = 3)
    public void test10_negativeFirstEmailFieldEmpty() {

        log.info(String.format("\ntest10_negativeFirstEmailFieldEmpty\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailMain(emptyStr);
            log.info(String.format("click and input %s in email field", emptyStr));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // second email field empty
    @Test(priority = 3)
    public void test11_negativeSecondEmailFieldEmpty() {

        log.info(String.format("\ntest11_negativeSecondEmailFieldEmpty\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            String emptyStr = "";

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(emptyStr);
            log.info(String.format("click and input %s in email field repeat and click TAB", emptyStr));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // introduced various email address
    @Test(priority = 3)
    public void test12_negativeVariousEmailAddress() {

        log.info(String.format("\ntest12_negativeVariousEmailAddress\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(1 + EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", 1 + EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(PASS);
            log.info(String.format("click and input %s password field repeat", PASS));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // introduced various password
    @Test(priority = 3)
    public void test13_negativeVariousPassFields() {

        log.info(String.format("\ntest13_negativeVariousPassFields\n"));

        {

            ellos.homePage.clickLoginLink();
            log.info(String.format("click login link"));

        }

        {

            ellos.registrationPage.clickAndInputEmailMain(EMAIL);
            log.info(String.format("click and input %s in email field", EMAIL));

            ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMAIL);
            log.info(String.format("click and input %s in email field repeat and click TAB", EMAIL));

            ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
            log.info(String.format("click and input %s in password field and click TAB", PASS));

            ellos.registrationPage.clickAndInputPassRepeat(PASS + 1);
            log.info(String.format("click and input %s password field repeat", PASS + 1));

            ellos.registrationPage.windowScroll();
            log.info(String.format("window scroll"));

            ellos.registrationPage.clickButtonRegistration();
            log.info(String.format("click on registration button"));

        }

        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

}
