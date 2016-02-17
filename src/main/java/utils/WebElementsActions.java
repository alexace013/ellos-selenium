package utils;

import exception.AlertException;
import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

/**
 * @see {@link utils.WebInterface}
 */
public class WebElementsActions implements WebInterface {

    private final static Logger log = Logger.getLogger(WebElementsActions.class);
    private static WebDriverWait driverWait;
    private ConfigurationData config;
    private WebDriverWrapper driverWrapper;

    public WebElementsActions(WebDriverWrapper driverWrapper) {

        this.driverWrapper = driverWrapper;
        driverWait = new WebDriverWait(driverWrapper, 10);
        config = ConfigurationData.getConfigurationData();

    }

    /**
     * This method return the desired element with locator
     *
     * @param elementLocator search element locator
     * @return element {@link WebElement} driver from
     * configuration {@link WebElementsActions#config}
     * @throws ElementNoSuch If the locator cannot found
     */
    public WebElement getElement(String elementLocator) throws ElementNoSuch {

        log.info(String.format("get element < %s >", elementLocator));
        return driverWrapper.findElement(config.getLocator(elementLocator));

    }

    /**
     * Open page
     *
     * @param url url{@see uniform resource locator} of the page
     */
    @Override
    public void openPage(String url) {

        driverWrapper.get(url);
        log.info(String.format("browser open page < %s >" + url));

    }

    /**
     * Insert value into text input HTML field
     *
     * @param inputLocator search a locator for input
     * @param data         data input
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void input(String inputLocator, String data) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(inputLocator)).sendKeys(data);
        log.info(String.format("input < %s > and send < %s >", inputLocator, data));

    }

    /**
     * Clear text field or some field
     *
     * @param clearLocator search a locator
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clear(String clearLocator) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(clearLocator)).clear();
        log.info(String.format("clear element < %s >", clearLocator));

    }

    /**
     * Clear text field and input data
     *
     * @param inputLocator search a locator for input
     * @param inputData    search a locator for data input
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clearAndInput(String inputLocator, String inputData) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(inputLocator)).clear();
        driverWrapper.findElement(config.getLocator(inputLocator)).sendKeys(inputData);
        log.info(String.format("clear < %s > and input < %s >", inputLocator, inputData));

    }

    /**
     * Insert value into text input HTML field and Click ENTER
     * for Field which used in the xpath expression
     *
     * @param inputLocator search a locator for input
     * @param inputData    search a locator for data input
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clearAndInputAndClickEnter(String inputLocator, String inputData) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(inputLocator)).clear();
        driverWrapper.findElement(config.getLocator(inputLocator)).sendKeys(inputData);
        driverWrapper.findElement(config.getLocator(inputLocator)).sendKeys(Keys.ENTER);
        log.info(String.format("clear < %s > and send < %s > and click ENTER.", inputLocator, inputData));

    }

    /**
     * Click on element
     *
     * @param elementLocator search element locator for click
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clickElement(String elementLocator) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(elementLocator)).click();
        log.info(String.format("click element < %s >", elementLocator));

    }

    /**
     * Click a button
     *
     * @param buttonLocator search button locator for click
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clickButton(String buttonLocator) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(buttonLocator)).click();
        log.info(String.format("click on button < %s >", buttonLocator));

    }

    /**
     * Click a link
     *
     * @param linkLocator search link locator for click
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void clickLink(String linkLocator) throws ElementNoSuch {

        driverWrapper.findElement(config.getLocator(linkLocator)).click();
        log.info(String.format("click on link < %s >", linkLocator));

    }

    /**
     * Move to element and click on this element
     *
     * @param moveToLocator search move locator
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void moveToElement(String moveToLocator) throws ElementNoSuch {

        WebElement webElement = driverWrapper.findElement(config.getLocator(moveToLocator));
        Actions actions = new Actions(driverWrapper);

        actions.moveToElement(webElement);
        log.info(String.format("move to element < %s >", moveToLocator));
        actions.perform();

    }

    /**
     * Move to element and click on this element
     *
     * @param moveToLocator  search move locator
     * @param clickToElement search element for click
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void moveToElementAndClick(String moveToLocator, String clickToElement) throws ElementNoSuch {

        WebElement webElement = driverWrapper.findElement(config.getLocator(moveToLocator));
        Actions actions = new Actions(driverWrapper);

        actions.moveToElement(webElement);
        log.info(String.format("move to element < %s >", moveToLocator));
        actions.perform();
        clickElement(clickToElement);

    }

    /**
     * Select/deselect the checkbox
     *
     * @param checkBoxLocator search check box locator
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void selectCheckBox(String checkBoxLocator) throws ElementNoSuch {

        if (driverWrapper.findElement(config.getLocator(checkBoxLocator)).isSelected()) {
            driverWrapper.findElement(config.getLocator(checkBoxLocator)).click();
            log.info(String.format("select < %s >", checkBoxLocator));
        }

    }

    /**
     * Select/deselect the checkbox, the second parameter should be true or false
     *
     * @param checkBoxLocator  search check box locator
     * @param isCheckBoxSelect true if check box is select, otherwise false
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void selectCheckBox(String checkBoxLocator, boolean isCheckBoxSelect) throws ElementNoSuch {

        if (driverWrapper.findElement(config.getLocator(checkBoxLocator)).isSelected() &
                isCheckBoxSelect == false) {
            driverWrapper.findElement(config.getLocator(checkBoxLocator)).click();
            log.info(String.format("check box < %s > selected < %b >", checkBoxLocator, isCheckBoxSelect));
        }

        if (!driverWrapper.findElement(config.getLocator(checkBoxLocator)).isSelected() &
                isCheckBoxSelect == true) {
            driverWrapper.findElement(config.getLocator(checkBoxLocator)).click();
            log.info(String.format("check box < %s > selected < %b >", checkBoxLocator, isCheckBoxSelect));
        }

    }

    /**
     * Method is used to check that element is present on page
     *
     * @param elementLocator search element locator
     * @return true if element is present on page, otherwise false
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public boolean isElementPresent(String elementLocator) throws ElementNoSuch {

        if (!driverWrapper.findElement(config.getLocator(elementLocator)).isDisplayed()) {

            log.info(String.format("< %s > not present on page.", elementLocator));
            return false;

        }

        log.info(String.format("< %s > is present on page.", elementLocator));
        return true;

    }

    /**
     * This method is used to agree messages on pop-up windows
     *
     * @return true if alert is present on page, otherwise false
     * @throws AlertException If alert is not found on page
     */
    @Override
    public boolean isAlertPresentAndAccept() {

        boolean isAlertPresent = false;

        try {

            Alert alert = driverWrapper.switchTo().alert();
            alert.accept();
            isAlertPresent = true;
            log.info(String.format("alert is present on page"));

        } catch (AlertException e) {

            e.printStackTrace();
            log.error(String.format("alert is not found. NoAlertPresentException < %s >", e.getStackTrace()));
            return isAlertPresent;

        }

        log.info(String.format("success, alert no present on page"));
        return isAlertPresent;

    }

    /**
     * This method is used to get text from pop-up windows
     *
     * @return alert text
     * @throws AlertException If alert is not found on page
     */
    public String getAlertText() {

        String alertText;

        try {

            Alert alert = driverWrapper.switchTo().alert();
            alertText = alert.getText();
            alert.accept();
            log.info(String.format("alert text < %s >", alertText));

        } catch (AlertException e) {

            alertText = "alert is not found";
            log.error(String.format("< %s > . NoAlertPresentException < %s >", e.getStackTrace()));
            e.printStackTrace();

        }

        return alertText;

    }

    /**
     * First method for refresh page
     */
    @Override
    public void refreshPage() {

        driverWrapper.navigate().refresh();
        log.info(String.format("page < %s > refresh", driverWrapper.getCurrentUrl()));

    }

    /**
     * Wait the element on page specified time
     *
     * @param elementLocator search element locator which is not visible
     * @param timeoutSeconds the timeout in seconds when an expectation is called
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void waitElementNotVisible(String elementLocator, int timeoutSeconds) throws ElementNoSuch {

        WebDriverWait webDriverWait = new WebDriverWait(driverWrapper, timeoutSeconds);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(config.getLocator(elementLocator)));

    }

    /**
     * An expectation for checking that an element is present on the DOM of a page and visible.
     * Visibility means that the element is not only displayed but also has a height and width
     * that is greater than 0.
     * Advantages of this method over isElementPresent(By elementLocator);
     * is that it expects the appearance of an element.
     *
     * @param elementLocator search element locator
     * @return true If element is present,otherwise false
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public boolean waitForElementPresent(String elementLocator) throws ElementNoSuch {

        if (elementLocator != null) {

            driverWait.until(ExpectedConditions.
                    visibilityOfElementLocated(config.getLocator(elementLocator)));

            log.info(String.format("wait for element < %s > present", elementLocator));

            return true;

        } else {

            log.info(String.format("waiting for the appearance of the element < %s > was not successful, " +
                    "wait for element < %s > present", elementLocator, elementLocator));

            return false;

        }

    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param elementLocator used to find the element
     * @return true If the WebElement once it is located and clickable (visible and enabled), otherwise false
     * @throws IOException If the locator cannot found
     */
    @Override
    public boolean waitElementToBeClickable(String elementLocator) throws ElementNoSuch {

        if (driverWait.until(ExpectedConditions.
                elementToBeSelected(config.getLocator(elementLocator)))) {

            driverWait.until(ExpectedConditions.elementToBeClickable(config.getLocator(elementLocator)));
            log.info(String.format("wait element < %s > to be clickable", elementLocator));

            return true;

        }

        log.info(String.format("wait element < %s > not to be clickable", elementLocator));

        return false;

    }

    /**
     * This method is used to wait for getting response from all Ajax requests
     *
     * @param timeoutSeconds the timeout in seconds when an expectation is called
     * @return true If {@param driver} instanceof {@link JavascriptExecutor},otherwise false
     */
    @Override
    public boolean waitForAjaxResponse(int timeoutSeconds) {

        if (driverWrapper instanceof JavascriptExecutor) {

            JavascriptExecutor jsDriver = (JavascriptExecutor) driverWrapper;

            for (int i = 0; i < timeoutSeconds; i++) {

                Long numberOfConnections = (Long) jsDriver.executeScript("return jQuery.active");

                if (numberOfConnections instanceof Long) {

                    log.debug(String.format("number of active jQuery Ajax calls is < %d >", numberOfConnections));

                    if (numberOfConnections == 0) {
                        break;
                    }

                }

            }

            return true;

        } else {

            log.info(String.format("web elements actions driver: < %s > can't execute JavaScript", driverWrapper));
            return false;

        }

    }

    /**
     * This method return a list of elements
     *
     * @param elementLocator search element locator
     * @return elements {@link List<WebElement>} driver find elements from
     * configuration {@link WebElementsActions#CONFIGURATION}
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public List<WebElement> getElements(String elementLocator) throws ElementNoSuch {

        log.info(String.format("get elements < %s >", elementLocator));
        return driverWrapper.findElements(config.getLocator(elementLocator));

    }

    /**
     * Press a button TAB {@info is recommended to enter a single value in
     * {@link WebElementsActions#pressTAB(String)}
     *
     * @param locator search locator for press button {@link Keys#TAB}
     * @throws ElementNoSuch If the locator cannot found
     */
    @Override
    public void pressTAB(String locator) throws ElementNoSuch {

        WebElement webElement = driverWrapper.findElement(config.getLocator(String.valueOf(locator)));
        webElement.sendKeys(Keys.TAB);
        log.info(String.format("press TAB"));

    }

    /**
     * Press a button Space
     *
     * @param locator press the space on the locator
     * @see {@link Keys#SPACE}
     */
    @Override
    public void pressSpace(String locator) throws ElementNoSuch {

        WebElement webElement = driverWrapper.findElement(config.getLocator(locator));
        webElement.sendKeys(Keys.SPACE);
        log.info(String.format("press space"));

    }

    /**
     * Scroll a window
     *
     * @see {@link JavascriptExecutor} and {@link JavascriptExecutor#executeScript(String, Object...)}
     */
    @Override
    public void windowScroll() {

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverWrapper;
        // Vertical scroll - down by 100  pixels
        javascriptExecutor.executeScript("window.scrollBy(0,100)", "");

    }

}