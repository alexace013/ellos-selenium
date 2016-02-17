package pages;

import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * This class works with home page {@see http://www.ellos.se/}
 */
public class HomePage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    public HomePage(WebDriverWrapper driverWrapper) {

        super(driverWrapper, MAIN_PAGE);
        openPage();

    }

    /**
     * Click logo link
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)}
     */
    public void clickLogo() {

        try {

            web.clickLink("logoCenterLink");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to registration page {@see https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2finspiration}
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)} and
     *                       {@link WebElementsActions#isElementPresent(String)}
     */
    public void switchToRegistrationPage() {

        try {

            web.clickLink("loginLink");

            if (web.isElementPresent("loginFieldInput")) {

                log.info("Switch to LOGIN_PAGE successful.");

            } else {

                log.info("Switch to LOGIN_PAGE failed.");

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to order direct page {@see http://www.ellos.se/Checkout/Basket.aspx}
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)} and
     *                       {@link WebElementsActions#isElementPresent(String)}
     */
    public void switchToOrderDirect() {

        try {

            web.clickLink("orderDirectLink");

            if (web.isElementPresent("isOrderDirectPage")) {

                log.info(String.format("switch to order direct page successful"));

            } else {

                log.info(String.format("switch to order page failed"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to woman page {@see http://www.ellos.se/dam}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToWomanPage() {

        try {

            web.moveToElementAndClick("womanMenu", "womanMenuLink");

            if (web.waitForElementPresent("inThePage")) {

                log.info(String.format("switch to woman page was correct"));

            } else {

                log.info(String.format("switch to woman page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to man page {@see http://www.ellos.se/herr}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToManPage() {

        try {

            web.moveToElementAndClick("manMenu", "manMenuLink");

            if (web.waitForElementPresent("manNavigationLink")) {

                log.info(String.format("switch to man page was correct"));

            } else {

                log.info(String.format("switch to man page was incorrect"));

            }


        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to barn page {@see http://www.ellos.se/barn}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToChildPage() {

        try {

            web.moveToElementAndClick("barnMenu", "barnMenuLink");

            if (web.waitForElementPresent("barnNavigationLink")) {

                // this method is used because it is not visible element on next page
                web.windowScroll();

                log.info(String.format("switch to barn page was correct"));

            } else {

                log.info(String.format("switch to barn page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to sport page {@see http://www.ellos.se/sport}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToSportPage() {

        try {

            web.moveToElementAndClick("sportMenu", "sportMenuLink");

            if (web.waitForElementPresent("sportNavigationLink")) {

                // this method is used because it is not visible element on next page
                web.windowScroll();

                log.info(String.format("switch to sport page was correct"));

            } else {

                log.info(String.format("switch to sport page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to underkläder & bad page {@see http://www.ellos.se/underklader-bad}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToLinenAndBathPage() {

        try {

            web.moveToElementAndClick("linen&bathMenu", "linen&bathMenuLink");

            if (web.waitForElementPresent("linen&bathNavigationLink")) {

                // this method is used because it is not visible element on next page
                web.windowScroll();

                log.info(String.format("switch to linen and bath page was correct"));

            } else {

                log.info(String.format("switch to linen and bath page page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to skor page {@see http://www.ellos.se/skor}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToFootwearPage() {

        try {

            web.moveToElementAndClick("footwearMenu", "footwearMenuLink");

            if (web.waitForElementPresent("footwearNavigationLink")) {

                log.info(String.format("switch to footwear page was correct"));

            } else {

                log.info(String.format("switch to footwear page was incorrect"));
            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to hem page {@see http://www.ellos.se/hem}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToHemPage() {

        try {

            web.moveToElementAndClick("hemMenu", "hemMenuLink");

            if (web.waitForElementPresent("hemNavigationLink")) {

                log.info(String.format("switch to hem page was correct"));

            } else {

                log.info(String.format("switch to hem page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to electronic page {@see http://www.ellos.se/elektronik}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToElectronicPage() {

        try {

            web.moveToElementAndClick("electronicMenu", "electronicMenuLink");

            if (web.waitForElementPresent("electronicNavigationLink")) {

                log.info(String.format("switch to electronic page was correct"));

            } else {

                log.info(String.format("switch to electronic page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to shonhet page {@see http://www.ellos.se/skonhet-halsa}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToBeautyAndHealthPage() {

        try {

            web.moveToElementAndClick("beautyAndHealthMenu", "beautyAndHealthMenuLink");

            if (web.waitForElementPresent("beautyAndHealthNavigationLink")) {

                log.info(String.format("switch to beauty and health page was correct"));

            } else {

                log.info(String.format("switch to beauty and health page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to plus page {@see http://www.ellos.se/plus/?N=1z141kn}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToPlusPage() {

        try {

            web.moveToElementAndClick("plusMenu", "plusMenuLink");

            if (web.waitForElementPresent("plusNavigationLink")) {

                log.info(String.format("switch to plus page was correct"));

            } else {

                log.info(String.format("switch to plus page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to REA page {@see http://www.ellos.se/rea}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToREAPage() {

        try {

            web.moveToElementAndClick("reaMenu", "reaMenuLink");

            if (web.waitForElementPresent("reaNavigationLink")) {

                log.info(String.format("switch to rea page was correct"));

            } else {

                log.info(String.format("switch to rea page was incorrect"));
            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Switch to inspiration page {@see http://www.ellos.se/inspiration}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToInspirationPage() {

        try {

            web.moveToElementAndClick("inspirationMenu", "inspirationMenuLink");

            if (web.waitForElementPresent("inspirationNavigationLink")) {

                log.info(String.format("switch to inspiration page was correct"));

            } else {

                log.info(String.format("switch to inspiration page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Switch to resor page {@see http://www.ellos.se/g/travel/travelStart?menuId=34}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)} and
     *                       {@link WebElementsActions#waitForElementPresent(String)}
     */
    public void switchToResorPage() {

        try {

            web.moveToElementAndClick("resorMenu", "resorMenuLink");

            if (web.waitForElementPresent("resorNavigationLink")) {

                log.info(String.format("switch to resor page was correct"));

            } else {

                log.info(String.format("switch to resor page was incorrect"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));
        }


    }

    /**
     * Close the blurb in the page
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickButton(String)}
     */
    public void closeBlurb() {

        if (web.isElementPresent("buttonBlurb")) {

            try {

                web.clickButton("buttonBlurb");

            } catch (ElementNoSuch e) {

                e.printStackTrace();
                log.error(String.format("Exception < %s >", e.getStackTrace()));
            }

        }

    }

    /**
     * Click on logout link
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)}
     */
    public void clickLogoutLink() {

        try {

            web.clickLink("logoutLink");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Click on login link
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)}
     */
    public void clickLoginLink() {

        try {

            web.clickLink("loginLink");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method verifies a successful user login
     *
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isUserLogIn() {

        try {

            if (web.isElementPresent("logoutLink")) {

                log.info(String.format("login was correct"));
                return true;

            } else {

                log.info(String.format("login was failed"));
                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Method verifies a successful user logout
     *
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isUserLogOut() {

        try {

            if (web.isElementPresent("loginLink")) {

                log.info(String.format("logout was correct"));
                return true;

            } else {

                log.info(String.format("logout was faliled"));
                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Refresh the home page
     */
    public void refreshHomePage() {
        web.refreshPage();
    }

}
