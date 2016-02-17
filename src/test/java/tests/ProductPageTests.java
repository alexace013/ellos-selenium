package tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ClassNameUtil;

public class ProductPageTests extends Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    // test woman product page
    @Test(priority = 1)
    public void test1_womanProductPage() {

        {

            ellos.homePage.closeBlurb();
            ellos.homePage.switchToWomanPage();

        }

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test man product page
    @Test(priority = 2)
    public void test2_manProductPage() {

        ellos.homePage.switchToManPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test barn product page
    @Test(priority = 3)
    public void test3_barnProductPage() {

        ellos.homePage.switchToChildPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test sport product page
    @Test(priority = 4)
    public void test4_sportProductPage() {

        ellos.homePage.switchToSportPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test linen and bath product page
    @Test(priority = 5)
    public void test5_linenAndBathPage() {

        ellos.homePage.switchToLinenAndBathPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test footwear product page
    @Test(priority = 6)
    public void test6_footwearPage() {

        ellos.homePage.switchToFootwearPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test hem product page
    @Test(priority = 7)
    public void test7_hemPage() {

        ellos.homePage.switchToHemPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test electronic product page
    @Test(priority = 8)
    public void test8_electronicPage() {

        ellos.homePage.switchToElectronicPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test beauty and health product page
    @Test(priority = 9)
    public void test9_beautyAndHealthPage() {

        ellos.homePage.switchToBeautyAndHealthPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test plus product page
    @Test(priority = 10)
    public void test10_plusPage() {

        ellos.homePage.switchToPlusPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test rea product page
    @Test(priority = 11)
    public void test11_reaPage() {

        ellos.homePage.switchToREAPage();

        {

            ellos.productPage.switchToProductCategory();
            ellos.productPage.switchToFirstPositionCategory();
            ellos.productPage.isTheProductPage();

        }

        Assert.assertTrue(ellos.productPage.checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();


    }

    // test inspiration product page
    @Test(priority = 12)
    public void test12_inspirationPage() {

        ellos.homePage.switchToInspirationPage();

        ellos.productPage.forInspirationPage();

//        Assert.assertTrue(getProductPage().checkCorrectSwitchToProductPage(), "correct switch to product page");

        ellos.productPage.switchToHomePage();

    }

    // test resor product page
    @Test(priority = 13)
    public void test13_resorPage() {

        ellos.homePage.switchToResorPage();

        ellos.productPage.forResorPage();

        ellos.productPage.switchToHomeFinishedTest();

    }

}
