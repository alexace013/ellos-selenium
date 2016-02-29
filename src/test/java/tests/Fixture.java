package tests;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Ellos;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverFactory;
import utils.WebDriverWrapper;

import java.util.concurrent.TimeUnit;

public class Fixture {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private static final String impWait = PropertyLoader.loadProperty("wait.timeout");

    public static WebDriverWrapper driverWrapper;
    public static Ellos ellos;

    @BeforeSuite
    public void startBrowser() {

        driverWrapper = new WebDriverWrapper(WebDriverFactory.getInstance());
        driverWrapper.manage().timeouts().implicitlyWait(Long.parseLong(impWait), TimeUnit.SECONDS);

        try {
            ellos = new Ellos(driverWrapper);
        } catch (Exception e) {
            e.printStackTrace();
        }

        log.info(String.format("start test suit execution"));

    }

    @AfterSuite
    public void quitBrowser() {

        driverWrapper.quit();

        log.info(String.format("tests suite execution completed"));

    }

}
