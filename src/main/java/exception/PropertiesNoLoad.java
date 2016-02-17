package exception;

import utils.ConfigurationData;

import java.io.IOException;

/**
 * This exception used in {@link ConfigurationData#loadPropertiesToMap()}
 * */

public class PropertiesNoLoad extends IOException {

    private static final String EXCEPTION_NAME = "PropertiesNoLoadException: ";

    public PropertiesNoLoad(String message) {
        super(String.format(EXCEPTION_NAME + "< %s >", message));
    }
}
