package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ClassNameUtil;

public class ProductPageTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    // test woman product page
    @Test(priority = 1, enabled = true)
    public void test1_womanProductPage() {

        log.info(String.format("\ntest1_womanProductPage\n"));

        ellos.productPage.openPage();
        ellos.homePage.closeBlurb();
        ellos.homePage.switchToWomanPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test man product page
    @Test(priority = 2, enabled = true)
    public void test2_manProductPage() {

        log.info(String.format("\ntest2_manProductPage\n"));

        ellos.homePage.switchToManPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test barn product page
    @Test(priority = 3, enabled = true)
    public void test3_barnProductPage() {

        log.info(String.format("\ntest3_barnProductPage\n"));

        ellos.homePage.switchToChildPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test sport product page
    @Test(priority = 4, enabled = true)
    public void test4_sportProductPage() {

        log.info(String.format("\ntest4_sportProductPage\n"));

        ellos.homePage.switchToSportPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test linen and bath product page
    @Test(priority = 5, enabled = true)
    public void test5_linenAndBathPage() {

        log.info(String.format("\ntest5_linenAndBathPag\n"));

        ellos.homePage.switchToLinenAndBathPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test footwear product page
    @Test(priority = 6, enabled = true)
    public void test6_footwearPage() {

        log.info(String.format("\ntest6_footwearPage\n"));

        ellos.homePage.switchToFootwearPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test hem product page
    @Test(priority = 7, enabled = true)
    public void test7_hemPage() {

        log.info(String.format("\ntest7_hemPage\n"));

        ellos.homePage.switchToHemPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test electronic product page
    @Test(priority = 8, enabled = true)
    public void test8_electronicPage() {

        log.info(String.format("\ntest8_electronicPage\n"));

        ellos.homePage.switchToElectronicPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test beauty and health product page
    @Test(priority = 9, enabled = true)
    public void test9_beautyAndHealthPage() {

        log.info(String.format("\ntest9_beautyAndHealthPage\n"));

        ellos.homePage.switchToBeautyAndHealthPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test plus product page
    @Test(priority = 10, enabled = true)
    public void test10_plusPage() {

        log.info(String.format("\ntest10_plusPage\n"));

        ellos.homePage.switchToPlusPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test rea product page
    @Test(priority = 11, enabled = true)
    public void test11_reaPage() {

        log.info(String.format("\ntest11_reaPage\n"));

        ellos.homePage.switchToREAPage();
        ellos.productPage.switchToProductCategory();
        ellos.productPage.switchToFirstPositionCategory();
        ellos.productPage.isTheProductPage();
        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test inspiration product page
    @Test(priority = 12, enabled = true)
    public void test12_inspirationPage() {

        log.info(String.format("\ntest12_inspirationPage\n"));

        ellos.homePage.switchToInspirationPage();
        ellos.productPage.forInspirationPage();
//        Assert.assertTrue(getProductPage().checkCorrectSwitchToProductPage(), "correct switch to product page");
        ellos.productPage.switchToHomePage();

    }

    // test resor product page
    @Test(priority = 13, enabled = true)
    public void test13_resorPage() {

        log.info(String.format("\ntest13_resorPage\n"));

        ellos.homePage.switchToResorPage();
        ellos.productPage.forResorPage();
        ellos.productPage.switchToHomeFinishedTest();

    }

}
