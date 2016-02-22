package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;

public class ScreenShotMaker {

    private static String screenShotDirectory;
    protected WebDriverWrapper driver;

    public ScreenShotMaker(WebDriverWrapper driver) {
        this.driver = driver;
        screenShotDirectory = PropertyLoader.loadProperty("screenshot.folder");
        File scrDir = new File(screenShotDirectory);
        if (!scrDir.exists()) {
            scrDir.mkdirs();
        }
    }

    public static void clearScreenShotSubDirectory(String screenShotSubDirectory) {
        File scrSubDir = new File(PropertyLoader.loadProperty("project.dir"),
                (new File(screenShotDirectory, screenShotSubDirectory)).toString());
        if (scrSubDir.exists()) {
            try {
                FileUtils.cleanDirectory(scrSubDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void takeScreenShot(String scrName) {
        String scrFormat = PropertyLoader.loadProperty("screenshot.defaultFormat");
        try {
            Augmenter augmenter = new Augmenter();
            File scrFile = ((TakesScreenshot) augmenter.augment(driver)).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(screenShotDirectory + scrName + scrFormat));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


