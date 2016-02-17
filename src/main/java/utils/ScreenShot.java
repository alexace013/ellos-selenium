package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

public class ScreenShot {

    /**
     * Private method for made screenshot page
     *
     * @param driver     the web driver must be passed {@link WebDriver}
     * @param filePath   input file path, where is saved you screen shot file
     * @param fileName   input name screenshot file
     * @param fileFormat input the format in which the file is saved
     * @throws IOException {@link FileUtils#copyFile(File, OutputStream)}
     */
    public static void screenShot(WebDriver driver, String filePath, String fileName, String fileFormat) throws IOException {

        // generate random value for saved all screen shot file, where used this method
        int rand = new Random().nextInt();
        // the path, where to save screenshot and file name and file format
        String path = filePath + fileName + rand + fileFormat;

        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(path));

    }

}
