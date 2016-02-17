package utils;

import exception.ElementNoSuch;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * @author alexander bakhin
 * @version 1.02
 * @info This interface describes the behavior of use of Web pages. Some
 * methods throw exception {@link ElementNoSuch}
 */

public interface WebInterface {

    void openPage(String url);

    void input(String inputLocator, String inputData) throws ElementNoSuch;

    void clear(String locator) throws ElementNoSuch;

    void clearAndInput(String inputLocator, String inputData) throws ElementNoSuch;

    void clearAndInputAndClickEnter(String inputLocator, String inputData) throws ElementNoSuch;

    void clickElement(String elementLocator) throws ElementNoSuch;

    void clickButton(String buttonLocator) throws ElementNoSuch;

    void clickLink(String linkLocator) throws ElementNoSuch;

    void moveToElement(String moveToLocator) throws ElementNoSuch;

    void moveToElementAndClick(String movToLocator, String clickToElement) throws ElementNoSuch;

    void selectCheckBox(String checkBoxLocator) throws ElementNoSuch;

    void selectCheckBox(String checkBoxLocator, boolean isCheckBoxSelect) throws ElementNoSuch;

    boolean isElementPresent(String elementLocator) throws ElementNoSuch;

    boolean isAlertPresentAndAccept();

    String getAlertText();

    void refreshPage();

    void waitElementNotVisible(String elementLocator, int timeoutSeconds) throws ElementNoSuch;

    boolean waitForElementPresent(String elementLocator) throws ElementNoSuch;

    boolean waitElementToBeClickable(String elementLocator) throws ElementNoSuch;

    boolean waitForAjaxResponse(int timeoutSeconds);

    WebElement getElement(String elementLocator) throws ElementNoSuch;

    List<WebElement> getElements(String elementLocator) throws ElementNoSuch;

    void pressTAB(String locator) throws ElementNoSuch;

    void pressSpace(String locator) throws ElementNoSuch;

    void windowScroll();


}
