package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ClassNameUtil;

public class ProductAddToBasketTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    @BeforeMethod
    public void setUp() {

        ellos.homePage.openPage();

    }

    @Test
    public void test1_addFirstProduct() {

        log.info(String.format("\ntest1_addFirstProduct\n"));

//        if (ellos.registrationPage.openPage()) {
//            ellos.registrationPage.switchToHomePage();
//        }

        ellos.homePage.closeBlurb();
        ellos.homePage.refreshHomePage();
        ellos.homePage.switchToElectronicPage();
//        getBasketPage().switchToMobile();
        ellos.productPage.switchToSecondPositionCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.addProductToBasket();
        ellos.screenShot.makeScreenShot();
        ellos.productPage.switchToHomePage();
//        Assert.assertTrue(getProductPage().textPresent(), "success page with iPhone 6 Plus 16GB Space Gray");

    }

    @Test
    public void test2_addSecondProduct() {

        log.info(String.format("test2_addSecondProduct"));

        ellos.homePage.switchToManPage();
        ellos.productPage.switchToProductCategory();
//        getProductPage().switchToFirstPositionCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addProductToBasket();
        ellos.screenShot.makeScreenShot("test2");
        ellos.productPage.switchToHomePage();


    }

    @Test
    public void test3_addThirdProduct() {

        // TODO must be *XL size

    }

}
