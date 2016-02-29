package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
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

        ellos.homePage.closeBlurb();
        ellos.homePage.switchToElectronicPage();
        ellos.productPage.switchToSecondPositionCategory();
        ellos.productPage.switchToFirstPositionCategory();
        Assert.assertTrue(ellos.productPage.textPresent(), "success product page");
        ellos.productPage.addProductToBasket();
        ellos.screenShot.makeScreenShot();
        ellos.productPage.switchToHomePage();

    }

    @Test
    public void test2_addSecondProduct() {

        log.info(String.format("\ntest2_addSecondProduct\n"));

        ellos.homePage.switchToManPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.selectColor();
        ellos.productPage.selectSize();
        ellos.productPage.addProductToBasket();
        ellos.screenShot.makeScreenShot("test2");
        ellos.productPage.switchToHomePage();


    }

    @Test(enabled = false)
    public void test3_addThirdProduct() {

        // TODO must be *XL size

    }

}
