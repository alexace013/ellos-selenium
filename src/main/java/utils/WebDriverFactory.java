package utils;

import net.anthavio.phanbedder.Phanbedder;
import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

public class WebDriverFactory {

    public static final String browserName = PropertyLoader.loadProperty("browser.name");
    public static final String browserVersion = PropertyLoader.loadProperty("browser.version");
    public static final String platform = PropertyLoader.loadProperty("browser.platform");

    public static final String gridHub = PropertyLoader.loadProperty("grid2.hub");

    /* Platform constants */
    public static final String WINDOWS = PropertyLoader.loadProperty("platform.windows");
    public static final String LINUX = PropertyLoader.loadProperty("platform.linux");
    public static final String MAC = PropertyLoader.loadProperty("platform.mac");

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    /*Browsers constants*/
    private static final String FIREFOX = "firefox";
    private static final String CHROME = "chrome";
    private static final String INTERNET_EXPLORER = "ie";
    private static final String HTML_UNIT = "htmlunit";
    private static final String PHANTOMJS = "phantomjs";

    private static WebDriver driver;
    private static GridInitialization gridInit = null;

    public WebDriverFactory() {
    }

    /**
     * Factory method to return a RemoteWebDriver instance given the url of
     * the Grid hub and a Browser instance.
     * <p>
     * SetUp gridHub : browserName, browserVersion, platform.
     *
     * @return {@link WebDriver}
     */
    public static WebDriver getInstance() {

        gridInit = new GridInitialization(browserName, browserVersion, platform);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setJavascriptEnabled(true);
        log.info(String.format("<--- start work web_driver factory --->"));
        setBrowserAndVersion(capabilities);
        log.info(String.format(" <--- successful set up browser & version = %s --->", capabilities));
        setPlatform(capabilities);
        log.info(String.format(" <---successful set up platform = %s --->", capabilities));

        driver = new RemoteWebDriver(getHubURL(), capabilities);
        driver.manage().deleteAllCookies();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.manage().window().maximize();
        log.info(String.format("Screen resolution - %s", driver.manage().window().getSize()));

        return driver;

    }

    /**
     * Factory method to return a WebDriver instance given the browser to hit.
     *
     * @param capabilities DesiredCapabilities object coming from getInstance().
     */
    public static void setBrowserAndVersion(DesiredCapabilities capabilities) {

        if (CHROME.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.chrome();
            System.setProperty("webdriver.chrome.driver", PropertyLoader.loadProperty("chromedriver.path"));
            capabilities.setCapability("chrome.switches",
                    Arrays.asList("--ignore-certificate-errors"));
            capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);

        } else if (FIREFOX.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.firefox();
            capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

            /**
             * Most likely PHANTOMJS does not work!
             * Need debug!
             */
        } else if (PHANTOMJS.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            File phantomjs = Phanbedder.unpack();
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    PropertyLoader.loadProperty("phantomjsdriver.path"));
            /*capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    phantomjs.getAbsolutePath());*/


        } else if (INTERNET_EXPLORER.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("browserstack.ie.enablePopups", false);

        } else if (HTML_UNIT.equals(browserName)) {
            capabilities.setBrowserName(browserName);
            capabilities = DesiredCapabilities.htmlUnit();

        }

        if (browserVersion != null) {
            capabilities.setVersion(browserVersion);
            capabilities.setCapability("browser_version", browserVersion);
        }

    }

    /**
     * Method makes the check and returns hub url
     *
     * @return hub url {@link URL}
     */
    public static URL getHubURL() {

        URL hubUrl = null;

        try {
            hubUrl = new URL(gridHub);
            log.info("<--- HUB_URL = " + gridHub + " --->");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // In case there is no Hub
        if (hubUrl == null) {
            log.error("HUBURL == null!\n");
            Assert.fail("vse propalo!");
            return null;
        } else {
            return hubUrl;
        }

    }

    /**
     * Helper method to set version and platform for a specific browser
     *
     * @param capabilities : DesiredCapabilities object coming from getInstance()
     */
    private static void setPlatform(DesiredCapabilities capabilities) {

        if (LINUX.equalsIgnoreCase(platform)) {
            capabilities.setPlatform(Platform.LINUX);

        } else if (WINDOWS.equalsIgnoreCase(platform)) {
            capabilities.setPlatform(Platform.WINDOWS);

        } else if (MAC.equalsIgnoreCase(platform)) {
            capabilities.setPlatform(Platform.MAC);

        } else {
            capabilities.setPlatform(Platform.ANY);
        }

    }

}
