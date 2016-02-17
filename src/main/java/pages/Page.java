package pages;

import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

public abstract class Page {

    public WebDriverWrapper driverWrapper;
    public WebElementsActions web;
    Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private String page;

    /**
     * Page constructor with two parameters
     *
     * @param driverWrapper the driver that is used on the page
     * @param page          the page URL
     */
    public Page(WebDriverWrapper driverWrapper, String page) {

        this.driverWrapper = driverWrapper;
        this.page = page;
        web = new WebElementsActions(driverWrapper);

    }

    /**
     * Page constructor with one parameter
     *
     * @param driverWrapper the driver that is used on the page
     */
    public Page(WebDriverWrapper driverWrapper) {

        this.driverWrapper = driverWrapper;
        web = new WebElementsActions(driverWrapper);

    }

    /**
     * Open Page in a browser
     *
     * @return true if page open successful, otherwise false
     * @throws ElementNoSuch {@link ElementNoSuch}
     */
    public boolean openPage() {

        try {

            log.info("start open page");
            driverWrapper.get(page);
            driverWrapper.getCurrentUrl();

        } catch (ElementNoSuch e) {

            log.error(String.format("Exception < %s >", e.getStackTrace()));
            return false;

        }

        log.info("page open successful");
        return true;

    }

    /**
     * Verification Page open correct. Check on pageLocator
     *
     * @param checkLocator locator on the page
     * @return true is page open and locator present on page
     * @throws ElementNoSuch {@link ElementNoSuch}
     */
    public boolean isOpenPage(String checkLocator) {

        try {

            if (web.isElementPresent(checkLocator)) {

                log.info(String.format("page: check is page open. < %s > is present!", checkLocator));
                log.info(String.format("< %s > : page is open", ClassNameUtil.getCurrentClassName()));

                return true;

            } else {

                Assert.fail("incorrect swatch");

            }

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

        return false;

    }

    /**
     * Get page title for verification correct switch between pages
     *
     * @return {@link String} title the page
     */
    public String getTitle() {

        return driverWrapper.getTitle();

    }

    /**
     * Get current page URL
     *
     * @return {@link String} current page URL
     */
    public String getCurrentPageURL() {

        return driverWrapper.getCurrentUrl();

    }

    /**
     * Delete all cookies
     */
    public void deleteAllCookies() {

        driverWrapper.manage().deleteAllCookies();

    }

}
