package exception;

import org.openqa.selenium.NoAlertPresentException;
import utils.WebElementsActions;

/**
 * This exception used in {@link WebElementsActions#isAlertPresentAndAccept()} and
 * {@link WebElementsActions#getAlertText()}
 */
public class AlertException extends NoAlertPresentException {

    private static final String EXCEPTION_NAME = "NoAlertPresentException: ";

    public AlertException(String message) {
        super(String.format(EXCEPTION_NAME + "< %s >", message));
    }

}
