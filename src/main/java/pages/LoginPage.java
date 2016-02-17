package pages;

import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * This class works with login page {@see https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2f}
 */
public class LoginPage extends Page {

    private final static Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    public LoginPage(WebDriverWrapper driverWrapper) {

        super(driverWrapper, MAIN_PAGE);
        openPage();

    }

    /**
     * Click on login field, if necessary, clear the field and input
     * {@param loginData} in login field
     *
     * @param loginData login data for search locator
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)}
     */
    public void clickAndInputLoginField(String loginData) {

        try {

            web.clickElement("loginFieldInput");

            isBeCleaned("loginFieldInput");

            web.input("loginFieldInput", loginData);

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

    }

    /**
     * User checking under their account
     *
     * @return true if user login success, otherwise false
     * @throws ElementNoSuch {@link utils.WebElementsActions#isElementPresent(String)}
     */
    public boolean isUserLogin() {

        try {

            if (web.isElementPresent("loginLink")) {
                return true;
            } else {
                return false;
            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

        return false;

    }

    /**
     * User checkout under their account
     *
     * @return true if user logout success, otherwise false
     * @throws ElementNoSuch {@link utils.WebElementsActions#isElementPresent(String)}
     */
    public boolean isUserLogout() {

        try {

            if (web.isElementPresent("logoutLink")) {
                return true;

            } else {

                return false;

            }

        } catch (ElementNoSuch e) {
            e.printStackTrace();
        }

        return false;

    }

    /**
     * Click on element and input {@param loginData} in login field and after this click key TAB
     *
     * @param loginData data login for search locator {@info example: e-mail}
     * @throws ElementNoSuch {@link utils.WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#input(String, String)} and
     *                       {@link WebElementsActions#pressTAB(String)}
     */
    public void clickAndInputLoginFieldAndClickTAB(String loginData) {

        try {

            web.clickElement("loginFieldInput");
            web.clear("loginFieldInput");
            web.input("loginFieldInput", loginData);
            web.pressTAB("loginFieldInput");

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

    }

    /**
     * Click on search element locator and input {@param passwordData} in password field
     *
     * @param passwordData data password for search locator {@info example: 12345}
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public void clickAndInputPassFieldWithOneLocator(String passwordData) {

        try {

            web.clickElement("passFieldInputSecond");

            isBeCleaned("passFieldInputSecond");

            web.input("passFieldInputSecond", passwordData);

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

    }

    /**
     * Click on search element locators and input {@param passwordData} in password field
     *
     * @param passwordData data password for search locator {@info example: 12345}
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public void clickAndInputPassFieldWithTwoLocators(String passwordData) {

        try {

            web.clickElement("passFieldInputFirst");

            isBeCleaned("passFieldInputSecond");

            web.input("passFieldInputSecond", passwordData);

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

    }

    /**
     * Click on login button
     *
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public void clickLoginButton() {

        try {

            web.clickElement("loginButton");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Click on text which is on the login page
     *
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public void clickToLoginPageText() {

        try {

            web.clickElement("loginPageText");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Click to close the popup help window
     *
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public void closeHelpBox() {

        try {

            web.clickElement("closeHelpBox");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Check whether there error message on a page
     *
     * @return true If message active, otherwise false
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public boolean isErrorMessagePresentOnPage() {

        try {

            if (web.isElementPresent("errorMessage")) {

                return true;

            } else {

                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Check active there error message on a page for one field
     *
     * @return false If one field is empty or failed data, otherwise true
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public boolean isErrorMessageOneFieldEmpty() {

        try {

            if (web.isElementPresent("errorMessageOneFieldEmpty")) {

                return true;

            } else {

                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Check active there error message on a page for fields
     *
     * @return false If fields is empty or failed data, otherwise true
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public boolean isErrorMessageFieldsEmpty() {

        try {

            if (web.isElementPresent("errorMessageEmptyFields")) {

                return true;

            } else {

                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Check there on the page pop-up help window
     *
     * @return true If pop-up help window is present, otherwise false
     * @throws ElementNoSuch {@link utils.WebElementsActions}
     */
    public boolean isHelpBoxActive() {

        try {

            if (web.isElementPresent("closeHelpBox")) {

                return true;

            } else {

                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Check there on the page pop-up help window
     *
     * @return true If element is present,otherwise false
     * @see {@link utils.WebElementsActions#waitForElementPresent(String)}
     */
    public boolean isHelpBoxPresent() {

        return web.waitForElementPresent("closeHelpBox");

    }

    /**
     * Private method for the purification of the input field , if text present in the field
     *
     * @param clearLocator search locator for clear
     * @throws ElementNoSuch IOException {@link utils.WebElementsActions}
     */
    private void isBeCleaned(String clearLocator) {

        try {

            if (!clearLocator.isEmpty()) {

                web.clear(clearLocator);

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();

        }

    }

}
