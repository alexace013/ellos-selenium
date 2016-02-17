package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class WebDriverWrapper implements WebDriver, TakesScreenshot {

    private static final int TIME_TO_WAIT = Integer.parseInt(PropertyLoader.loadProperty("wait.timeout"));
    public static WebDriver driver;

    public WebDriverWrapper(WebDriver driver) {

        this.driver = driver;

    }

    /**
     * Get the Web Driver.
     *
     * @return from this class static {@value #driver}{@link WebDriver}
     */
    @SuppressWarnings("JavadocReference")
    public WebDriver getOriginalDriver() {

        return driver;

    }

    /**
     * Load a new web page in the current browser window
     *
     * @param pageLink the URL to load. It is best to use a fully qualified URL
     */
    @Override
    public void get(String pageLink) {

        driver.get(pageLink);

    }

    /**
     * Get a string representing the current URL that the browser is looking at
     *
     * @return {@link String} the URL of the page currently loaded in the browser
     */
    @Override
    public String getCurrentUrl() {

        return driver.getCurrentUrl();

    }

    /**
     * The title of the current page
     *
     * @return {@link String} the title of the current page, with leading and
     * trailing whitespace stripped, or null if one is not already set
     */
    @Override
    public String getTitle() {

        return driver.getTitle();

    }

    /**
     * Find all elements within the current page using the given mechanism
     *
     * @param by {@link By} the locating mechanism to use
     * @return {@link List<WebElement>} A list of all WebElements, or an empty
     * list if nothing matches
     * @see org.openqa.selenium.WebDriver.Timeouts
     */
    @Override
    public List<WebElement> findElements(By by) {

        WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        return driver.findElements(by);

    }

    /**
     * Find the first WebElement using the given method.
     *
     * @param by the locating mechanism
     * @return the first matching element on the current page
     * @see {@link By}
     */
    @Override
    public WebElement findElement(By by) {

        WebDriverWait wait = new WebDriverWait(driver, TIME_TO_WAIT);
        wait.until(ExpectedConditions.presenceOfElementLocated(by));

        return driver.findElement(by);

    }

    /**
     * Get the source of the last loaded page.
     *
     * @return {@link String} The source of the current page.
     */
    @Override
    public String getPageSource() {

        return driver.getPageSource();

    }

    /**
     * Close the current window, quitting the browser if it's the last window currently open.
     */
    @Override
    public void close() {

        driver.close();

    }

    /**
     * Quits this driver, closing every associated window.
     */
    @Override
    public void quit() {

        driver.quit();

    }

    /**
     * Return a set of window handles which can be used to iterate
     * over all open windows of this WebDriver instance by
     * passing them to {@see {@link Options#window()}}switchTo().WebDriver.Options.window()
     *
     * @return {@link Set<String>} A set of window handles which can
     * be used to iterate over all open windows.
     */
    @Override
    public Set<String> getWindowHandles() {

        return driver.getWindowHandles();

    }

    /**
     * Return an opaque handle to this window that uniquely
     * identifies it within this driver instance.
     *
     * @return {@link String} Return an opaque handle to this
     * window that uniquely identifies it within this driver instance.
     * This can be used to switch to this window at a later date.
     */
    @Override
    public String getWindowHandle() {

        return driver.getWindowHandle();

    }

    /**
     * Send future commands to a different frame or window.
     *
     * @return {@link org.openqa.selenium.WebDriver.TargetLocator}
     * A TargetLocator which can be used to select a frame or window.
     */
    @Override
    public TargetLocator switchTo() {

        return driver.switchTo();

    }

    /**
     * An abstraction allowing the driver to access the browser's
     * history and to navigate to a given URL.
     *
     * @return {@link org.openqa.selenium.WebDriver.Navigation}
     * A {@link org.openqa.selenium.WebDriver.Navigation} that allows
     * the selection of what to do next.
     */
    @Override
    public Navigation navigate() {

        return driver.navigate();

    }

    /**
     * Gets the Option interface.
     * {@see {@link org.openqa.selenium.WebDriver.Options}}
     *
     * @return An option interface
     */
    @Override
    public Options manage() {

        return driver.manage();

    }

    /**
     * Capture the screenshot and store it in the specified location.
     *
     * @param outType {@see {@link OutputType<X>}} X - Return type for getScreenshotAs.
     * @return {@link X} Object in which is stored information about the screenshot.
     * @throws WebDriverException {@link WebDriverException}  - on failure.
     */
    @Override
    public <X> X getScreenshotAs(OutputType<X> outType) {

        try {

            if (driver instanceof FirefoxDriver) {

                return ((FirefoxDriver) driver).getScreenshotAs(outType);

            } else if (driver instanceof ChromeDriver) {

                return ((ChromeDriver) driver).getScreenshotAs(outType);

            } else if (driver instanceof InternetExplorerDriver) {

                return ((InternetExplorerDriver) driver).getScreenshotAs(outType);

            } else if (driver instanceof PhantomJSDriver) {

                return ((PhantomJSDriver) driver).getScreenshotAs(outType);

            } else

                return null;

        } catch (WebDriverException e) {

            e.printStackTrace();

        }

        return null;

    }

}
