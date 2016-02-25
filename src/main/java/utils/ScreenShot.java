package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Screenshot can be saved without have a constructor (static method,
 * but then need to specify all the parameters ) or with the help of the constructor,
 * where you specify the name of the file to be saved, if necessary.
 *
 * @author alexace013@gmail.com
 * @version 2.1
 * @throws IOException {@link IOException} when
 * {@link FileUtils#copyFile(File, OutputStream)} throw exception
 */
public class ScreenShot {

    /**
     * All default settings for default file
     */
    private static final String DEFAULT_FILE_PATH = PropertyLoader.loadProperty("screenshot.folder");
    private static final String DEFAULT_FILE_NAME = PropertyLoader.loadProperty("screenshot.name");
    private static final String DEFAULT_FILE_FORMAT = PropertyLoader.loadProperty("screenshot.format");

    // this constant created for numbers range
    private static final int CONST_RANGE = 10_000;

    private WebDriverWrapper driverWrapper;

    // CONSTRUCTOR
    public ScreenShot(WebDriverWrapper driverWrapper) {

        this.driverWrapper = driverWrapper;

    }

    /**
     * Public static method for made quickly screen shot page without constructor,
     * but you must input {@param filePath}, {@param fileName} and {@param fileFormat}
     * and input {@param driverWrapper}
     *
     * @param driverWrapper the web driverWrapper must be passed {@link WebDriver}
     * @param filePath      input file path, where is saved you screen shot file
     * @param fileName      input name screenshot file
     * @param fileFormat    input the format in which the file is saved
     * @throws IOException {@link FileUtils#copyFile(File, OutputStream)}
     */
    public static void quicklyScreenShot(WebDriverWrapper driverWrapper, String filePath,
                                         String fileName, String fileFormat) throws IOException {

        // generate random value for saved all screen shot file, where used this method
        int rand = new Random().nextInt(CONST_RANGE);
        // the path, where to save screenshot and file name and file format
        String path = filePath + fileName + rand + fileFormat;
        File screenShotFile = ((TakesScreenshot) driverWrapper.getOriginalDriver()).
                getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(path));

    }

    /**
     * This private method save screen shot with file name.
     *
     * @param fileName input path, where save screen shot
     * @throws {@link IOException} if file equal null or other error.
     */
    private void saveScreenShot(String fileName) {

        File screenShotFile = ((TakesScreenshot) driverWrapper.getOriginalDriver()).
                getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShotFile,
                    new File(DEFAULT_FILE_PATH + fileName + createRandomValue() + DEFAULT_FILE_FORMAT));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Private method for create random number with a range of numbers
     *
     * @return string with random number
     */
    private int createRandomValue() {

        return new Random().nextInt(CONST_RANGE);

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create default screen shot
     *
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot() {

        saveScreenShot(DEFAULT_FILE_NAME);

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create screen shot with {@param fileName}
     *
     * @param fileName input file path, where the file is saved.
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot(String fileName) {

        saveScreenShot(fileName);

    }

}
