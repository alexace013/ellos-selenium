package exception;

import utils.ConfigurationData;

import java.io.FileNotFoundException;

/**
 * This exception used in {@link ConfigurationData#loadPropertiesToMap()}
 * */

public class FileException extends FileNotFoundException {

    private static final String EXCEPTION_NAME = "FileException: ";

    public FileException(String message) {

        super(String.format(EXCEPTION_NAME + "< %s >", message));

    }


}
