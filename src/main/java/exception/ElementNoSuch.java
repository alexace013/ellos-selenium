package exception;

import java.util.NoSuchElementException;

/**
 * This exception used in {@link utils.WebElementsActions} and
 * {@link utils.ConfigurationData} and {@link utils.WebInterface}
 * and other classes of descendants
 */

public class ElementNoSuch extends NoSuchElementException {

    private static final String EXCEPTION_NAME = "ElementNoFoundException: ";

    public ElementNoSuch(String message) {

        super(String.format(EXCEPTION_NAME + "< %s >", message));

    }


}
