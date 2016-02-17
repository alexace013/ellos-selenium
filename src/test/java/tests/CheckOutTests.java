package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import random.RandomUser;
import utils.ClassNameUtil;

public class CheckOutTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String EMAIL = RandomUser.randomEmail();
    private static final String PASS = "qwerty123456";

    @Test(priority = 1)
    public void test1_addProductToBasket() {

        ellos.homePage.closeBlurb();
        ellos.homePage.switchToElectronicPage();
        ellos.productPage.switchToSecondPositionCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.addProductToBasket();
        ellos.productPage.switchToHomePage();

    }

    @Test(priority = 2)
    public void test2_switchToCheckOut() {

        ellos.homePage.switchToOrderDirect();
        ellos.checkoutPage.pressButtonCheckOut();
        ellos.registrationPage.switchToRegisterCustomer();
        ellos.checkoutPage.inputEmail(EMAIL);
        ellos.checkoutPage.inputEmailRepeat(EMAIL);
        ellos.checkoutPage.inputPassword(PASS);
        ellos.checkoutPage.inputPasswordRepeat(PASS);
        ellos.checkoutPage.inputFirstName("Bob");
        ellos.checkoutPage.inputLastName("Wasofskiy");
        ellos.checkoutPage.input_CO_address("c/o address");
        ellos.checkoutPage.inputAddress("Great Britain");
        ellos.checkoutPage.inputZipCode("0771 - 33 33 10");
        ellos.checkoutPage.inputCity("London");

    }

}
