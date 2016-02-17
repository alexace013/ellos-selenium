package pages;

import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * This class works with registration page {@see https://www.ellos.se/LoginAndRegistration/Login?returnUrl=%2f}
 */
public class RegistrationPage extends Page {

    //    private final static Logger log = Logger.getLogger("log4j.rootLogger");
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    public RegistrationPage(WebDriverWrapper driverWrapper) {

        super(driverWrapper, MAIN_PAGE);
        openPage();

    }

    /**
     * Method clicked and input data in the first email field
     *
     * @param email where this string is the E-mail address
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#input(String, String)}
     */
    public void clickAndInputEmailMain(String email) {

        try {

            web.clickElement("registrationEmailMain");
            web.clear("registrationEmailMain");
            web.input("registrationEmailMain", email);


        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method clicked and input data in the second email field
     *
     * @param email where this string is the E-mail address
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#input(String, String)} and
     *                       {@link WebElementsActions#pressTAB(String)}
     */
    public void clickAndInputEmailRepeatAndClickTAB(String email) {

        try {

            web.clickElement("registrationEmailRepeat");
            web.clear("registrationEmailRepeat");
            web.input("registrationEmailRepeat", email);
            web.pressTAB("registrationEmailRepeat");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method clicked and input data in the first password field
     *
     * @param password where this string is the E-mail address
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#input(String, String)} and
     *                       {@link WebElementsActions#pressTAB(String)}
     */
    public void clickAndInputPassMainAndClickTAB(String password) {

        try {

            web.clickElement("registrationPassMain");
            web.clear("registrationPassMain");
            web.input("registrationPassMain", password);
            web.pressTAB("registrationPassMain");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method clicked and input data in the second password field
     *
     * @param password where this string is the E-mail address
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#input(String, String)}
     */
    public void clickAndInputPassRepeat(String password) {

        try {

            web.clickElement("registrationPassRepeat");
            web.clear("registrationPassRepeat");
            web.input("registrationPassRepeat", password);

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method clicked and input data in the second email field (test method), this
     * method is deprecated
     *
     * @param password where this string is the E-mail address
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)} and
     *                       {@link WebElementsActions#clear(String)} and
     *                       {@link WebElementsActions#clearAndInputAndClickEnter(String, String)}
     */
    @Deprecated
    public void clickAndInputPassRepeatTest(String password) {

        try {

            web.clickElement("registrationPassRepeat");
            web.clear("registrationPassRepeat");
            web.clearAndInputAndClickEnter("registrationPassRepeat", password);

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * This method scroll you window
     */
    public void windowScroll() {

        web.windowScroll();

    }

    /**
     * This method click on check box
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)}
     */
    public void clickCheckBox() {

        try {

            web.clickElement("checkBoxAccept");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * This method click on the registration button
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickElement(String)}
     */
    public void clickButtonRegistration() {

        try {

            web.clickElement("buttonRegistration");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * This method click on login link if we need to get the registration page
     * and user does not come under its profile
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)}
     */
    public void clickLogin() {

        try {

            web.clickLink("loginLink");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * This method click on logout link if the user needs to log out and
     * the user under her own account
     *
     * @throws ElementNoSuch {@link WebElementsActions#clickLink(String)}
     */
    public void clickLogOut() {

        try {

            web.clickLink("logoutLink");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Method checks whether the user is logged under her own account
     *
     * @return true if user login successful, otherwise false
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isRegistrationSuccessful() {

        try {

            if (web.isElementPresent("correctRegistration")) {

                return true;

            } else if (web.isElementPresent("buttonRegistration")) {

                return false;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Method checks for an error message on the page, when password field empty.
     *
     * @return true if error message present on a page, otherwise false
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isErrorPassPresent() {

        try {

            if (web.isElementPresent("errorRegPassFieldOne")) {

                return true;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Method checks for an error message on the page, when one registration
     * field (email or password) empty.
     *
     * @return true if error message present on a page, otherwise false
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isErrorJustOneField() {

        try {

            if (web.isElementPresent("errorRegJustFirstEmail")) {

                return true;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Method checks for an error message on the page
     *
     * @return true if error message present on a page, otherwise false
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     */
    public boolean isErrorMessagePresent() {

        try {

            if (web.isElementPresent("errorRegMessage")) {

                return true;

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Switch from registration page to register customer page
     *
     * @throws ElementNoSuch {@link WebElementsActions#isElementPresent(String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void switchToRegisterCustomer() {

        try {

            if (web.isElementPresent("isCheckOutRegistration")) {

                web.moveToElementAndClick("buttonCheckOutRegistration", "buttonCheckOutRegistration");

                log.info(String.format("switch to full registration page"));

            } else {

                log.info(String.format("no switch to full registration page"));

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Refresh the home page
     */
    public void refreshHomePage() {
        web.refreshPage();
    }

}
