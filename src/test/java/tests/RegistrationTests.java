package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ClassNameUtil;
import utils.PropertyLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RegistrationTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private static final String PASS = PropertyLoader.loadProperty("user.new.password");
    private static final String EMPTY_STRING = "";

    // data provider for random email
    @DataProvider(name = "generate_random_email")
    public Iterator<Object[]> randomEmail() {

        List<Object[]> emailData = new ArrayList<Object[]>();
        emailData.add(new Object[]{generateRandomEmail()});
        return emailData.iterator();

    }

    // this method generate random email address
    private Object generateRandomEmail() {

        return PropertyLoader.loadProperty("user.new.email") +
                randomValue() + PropertyLoader.loadProperty("user.new.email.domain");

    }

    // this method generate random number
    private int randomValue() {

        // the range for generate numbers
        final int RANGE = 10_000;
        int value = new Random().nextInt(RANGE);

        // if the value is less than zero, make it positive
        if (value < 0) {
            value *= -1;
        }

        return value;

    }

    // all fields are filled in correctly
    @Test(priority = 1, dataProvider = "generate_random_email")
    public void test1_positiveRegistration(String email) {

        log.info(String.format("\ntest1_positiveRegistration\n"));

        ellos.registrationPage.openPage();
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isRegistrationSuccessful(),
                "registration is successful");
        ellos.homePage.clickLogoutLink();

    }

    // just first field is filled with an email
    @Test(priority = 2, dataProvider = "generate_random_email")
    public void test2_negativeOnlyFirstEmailField(String email) {

        log.info(String.format("\ntest2_negativeOnlyFirstEmailField\n"));

        ellos.homePage.closeBlurb();
        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in email field repeat and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in password field and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassRepeat(EMPTY_STRING);
        log.info(String.format("click and input %s password field repeat", EMPTY_STRING));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just second field is filled with an email
    @Test(priority = 2, dataProvider = "generate_random_email")
    public void test3_negativeOnlySecondEmailField(String email) {

        log.info(String.format("\ntest3_negativeOnlySecondEmailField\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(EMPTY_STRING);
        log.info(String.format("click and input %s in email field", EMPTY_STRING));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in password field and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassRepeat(EMPTY_STRING);
        log.info(String.format("click and input %s password field repeat", EMPTY_STRING));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just first field is filled with an password
    @Test(priority = 2)
    public void test4_negativeOnlyFirstPassField() {

        log.info(String.format("\ntest4_negativeOnlyFirstPassField\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(EMPTY_STRING);
        log.info(String.format("click and input %s in email field", EMPTY_STRING));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in email field repeat and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(EMPTY_STRING);
        log.info(String.format("click and input %s password field repeat", EMPTY_STRING));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // just second field is filled with an password
    @Test(priority = 2)
    public void test5_negativeOnlySecondPassField() {

        log.info(String.format("\ntest5_negativeOnlySecondPassField\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(EMPTY_STRING);
        log.info(String.format("click and input %s in email field", EMPTY_STRING));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in email field repeat and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in password field and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorJustOneField(), "registration is failed");

    }

    // only an email fields filled
    @Test(priority = 2, dataProvider = "generate_random_email")
    public void test6_negativeOnlyEmailFields(String email) {

        log.info(String.format("\ntest6_negativeOnlyEmailFields\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in password field and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassRepeat(EMPTY_STRING);
        log.info(String.format("click and input %s password field repeat", EMPTY_STRING));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // only an password fields filled
    @Test(priority = 2)
    public void test7_negativeOnlyPassFields() {

        log.info(String.format("\ntest7_negativeOnlyPassFields\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(EMPTY_STRING);
        log.info(String.format("click and input %s in email field", EMPTY_STRING));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in email field repeat and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // first password field is empty
    @Test(priority = 2, dataProvider = "generate_random_email")
    public void test8_negativeFirstPassFieldEmpty(String email) {

        log.info(String.format("\ntest8_negativeFirstPassFieldEmpty\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));

        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in password field and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // second password field is empty
    @Test(priority = 2, dataProvider = "generate_random_email")
    public void test9_negativeSecondPassFieldEmpty(String email) {

        log.info(String.format("\ntest9_negativeSecondPassFieldEmpty\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));

        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(EMPTY_STRING);
        log.info(String.format("click and input %s password field repeat", EMPTY_STRING));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // first email field empty
    @Test(priority = 3, dataProvider = "generate_random_email")
    public void test10_negativeFirstEmailFieldEmpty(String email) {

        log.info(String.format("\ntest10_negativeFirstEmailFieldEmpty\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(EMPTY_STRING);
        log.info(String.format("click and input %s in email field", EMPTY_STRING));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // second email field empty
    @Test(priority = 3, dataProvider = "generate_random_email")
    public void test11_negativeSecondEmailFieldEmpty(String email) {

        log.info(String.format("\ntest11_negativeSecondEmailFieldEmpty\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(EMPTY_STRING);
        log.info(String.format("click and input %s in email field repeat and click TAB", EMPTY_STRING));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // introduced various email address
    @Test(priority = 3, dataProvider = "generate_random_email")
    public void test12_negativeVariousEmailAddress(String email) {

        log.info(String.format("\ntest12_negativeVariousEmailAddress\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB("fail" + email);
        log.info(String.format("click and input %s in email field repeat and click TAB", "fail" + email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS);
        log.info(String.format("click and input %s password field repeat", PASS));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");

    }

    // introduced various password
    @Test(priority = 3, dataProvider = "generate_random_email")
    public void test13_negativeVariousPassFields(String email) {

        log.info(String.format("\ntest13_negativeVariousPassFields\n"));

        ellos.homePage.clickLoginLink();
        log.info(String.format("click login link"));
        ellos.registrationPage.clickAndInputEmailMain(email);
        log.info(String.format("click and input %s in email field", email));
        ellos.registrationPage.clickAndInputEmailRepeatAndClickTAB(email);
        log.info(String.format("click and input %s in email field repeat and click TAB", email));
        ellos.registrationPage.clickAndInputPassMainAndClickTAB(PASS);
        log.info(String.format("click and input %s in password field and click TAB", PASS));
        ellos.registrationPage.clickAndInputPassRepeat(PASS + 1);
        log.info(String.format("click and input %s password field repeat", PASS + 1));
        ellos.registrationPage.regPageScrollDown();
        log.info(String.format("window scroll down"));
        ellos.registrationPage.clickButtonRegistration();
        log.info(String.format("click on registration button"));
//            ellos.registrationPage.closeHelpBox();
        ellos.registrationPage.regPageScrollUp();
        log.info(String.format("window scroll up"));
        ellos.registrationPage.switchToHomePage();
//        Assert.assertTrue(ellos.registrationPage.isErrorMessagePresent(), "registration is failed");
        // TODO why is assert not work

    }

}
