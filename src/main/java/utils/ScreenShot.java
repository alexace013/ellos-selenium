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
 * Screenshot is saved to the path that is specified in the {@param filePath}  file with
 * the name {@param fileName} of and having a file format {@param fileFormat}.
 *
 * @author alexace013@gmail.com
 * @version 1.0
 * @throws IOException {@link IOException} when
 * {@link FileUtils#copyFile(File, OutputStream)} throw exception
 */
public class ScreenShot {

    private static final String DEFAULT_FILE_PATH = PropertyLoader.loadProperty("screenshot.folder");
    private static final String DEFAULT_FILE_FORMAT = PropertyLoader.loadProperty("screenshot.defaultFormat");

    private WebDriverWrapper driverWrapper;
    private String defaultFileName;
    private File screenShotFile;

    public ScreenShot(WebDriverWrapper driverWrapper) {

        this.driverWrapper = driverWrapper;
        this.defaultFileName = createDefaultFileName();
        // create screen shot.
        screenShotFile = (driverWrapper).getScreenshotAs(OutputType.FILE);

    }

    /**
     * Public static method for made quickly screen shot page without constructor,
     * but you must input {@param filePath}, {@param fileName} and {@param fileFormat}
     * and input {@param driverWrapper}
     *
     * @param driverWrapper the web driver must be passed {@link WebDriver}
     * @param filePath      input file path, where is saved you screen shot file
     * @param fileName      input name screenshot file
     * @param fileFormat    input the format in which the file is saved
     * @throws IOException {@link FileUtils#copyFile(File, OutputStream)}
     */
    public static void quicklyScreenShot(WebDriverWrapper driverWrapper, String filePath,
                                         String fileName, String fileFormat) throws IOException {

        // generate random value for saved all screen shot file, where used this method
        int rand = new Random().nextInt();
        // the path, where to save screenshot and file name and file format
        String path = filePath + fileName + rand + fileFormat;
        File screenShotFile = ((TakesScreenshot) driverWrapper.getOriginalDriver()).
                getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(path));

    }

    /**
     * Private method for create default file name
     *
     * @return string name with random numbers
     */
    private String createDefaultFileName() {

        return "scr_" + (new Random().nextInt(10_000));

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create default screen shot
     *
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot() {

        // final file with defaupt path name and format.
        String path = DEFAULT_FILE_PATH + defaultFileName + DEFAULT_FILE_FORMAT;
        saveScreenShot(path);

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create screen shot with {@param filePath}
     *
     * @param filePath input file path, where the file is saved.
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot(String filePath) {

        String path = filePath + defaultFileName + DEFAULT_FILE_FORMAT;
        saveScreenShot(path);

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create screen shot with {@param filePath} and {@param fileName}
     *
     * @param filePath input file path, where the file is saved.
     * @param fileName input file name, under which the file will be saved.
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot(String filePath, String fileName) {

        String path = filePath + fileName + DEFAULT_FILE_FORMAT;
        saveScreenShot(path);

    }

    /**
     * This method using, when created constructor ScreenShot.
     * Create screen shot with {@param filePath}, {@param fileName} and {@param fileFormat}
     *
     * @param filePath   input file path, where the file is saved.
     * @param fileName   input file name, under which the file will be saved.
     * @param fileFormat input file format. This extension will have a file.
     * @throws IOException {@link IOException} when {@link FileUtils#copyFile(File, OutputStream)}
     *                     throw exception
     */
    public void makeScreenShot(String filePath, String fileName, String fileFormat) {

        String path = filePath + fileName + fileFormat;
        saveScreenShot(path);

    }

    /**
     * This method save screen shot.
     *
     * @param path input path, where save screen sot
     */
    private void saveScreenShot(String path) {

        try {
            FileUtils.copyFile(screenShotFile, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
