package pages;

import exception.ElementNoSuch;
import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * // TODO
 */
public class CheckoutPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    public CheckoutPage(WebDriverWrapper driverWrapper) {

        super(driverWrapper, MAIN_PAGE);
        openPage();

    }

    /**
     * Press the button checkout (till kassan) in a page checkout {@see http://www.ellos.se/Checkout/Basket.aspx}
     *
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void pressButtonCheckOut() {

        try {

            web.windowScroll();
            web.moveToElementAndClick("buttonCheckout", "buttonCheckout");

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }

    }

    /**
     * Input email address in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputEmail(String email) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerEmailField", "registerCustomerEmailField");
        web.input("registerCustomerEmailField", email);

        try {

        } catch (ElementNoSuch e) {

            e.printStackTrace();
            log.error(String.format("Exception < %s >", e.getStackTrace()));

        }


    }

    /**
     * Input repeat email address in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputEmailRepeat(String email) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerEmailFieldConfirm", "registerCustomerEmailFieldConfirm");
        web.input("registerCustomerEmailFieldConfirm", email);

    }

    /**
     * Input password in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     * @throws ElementNoSuch {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputPassword(String password) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerPassFieldInputFirst", "registerCustomerPassFieldInputFirst");
        web.input("registerCustomerPassFieldInputSecond", password);

    }

    /**
     * Input repeat password in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputPasswordRepeat(String password) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerPassFieldInputFieldConfirmFirst",
                "registerCustomerPassFieldInputFieldConfirmFirst");
        web.input("registerCustomerPassFieldInputFieldConfirmSecond", password);

    }

    /**
     * Input first name in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputFirstName(String name) throws ElementNoSuch {

        web.windowScroll();
        web.moveToElementAndClick("registerCustomerFieldFirstName", "registerCustomerFieldFirstName");
        web.input("registerCustomerFieldFirstName", name);

    }

    /**
     * Input last name in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputLastName(String name) throws ElementNoSuch {

        web.windowScroll();
        web.moveToElementAndClick("registerCustomerFieldLastName", "registerCustomerFieldLastName");
        web.input("registerCustomerFieldLastName", name);

    }

    /**
     * Input c/o address in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void input_CO_address(String address) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerFieldCOAddress", "registerCustomerFieldCOAddress");
        web.input("registerCustomerFieldCOAddress", address);

    }

    /**
     * Input address in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputAddress(String address) throws ElementNoSuch {

        web.moveToElementAndClick("registerCustomerFieldAddress", "registerCustomerFieldAddress");
        web.input("registerCustomerFieldAddress", address);

    }

    /**
     * Input zip code in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputZipCode(String address) throws ElementNoSuch {

        web.windowScroll();
        web.moveToElementAndClick("registerCustomerFieldPostCode", "registerCustomerFieldPostCode");
        web.input("registerCustomerFieldPostCode", address);

    }

    /**
     * Input ciy in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputCity(String city) throws ElementNoSuch {

        web.windowScroll();
        web.moveToElementAndClick("registerCustomerFieldCity", "registerCustomerFieldCity");
        web.input("registerCustomerFieldCity", city);

    }

    /**
     * Input mobile phone in field on confirm register page
     * {@see https://www.ellos.se/LoginAndRegistration/RegisterCustomer}
     *
     * @throws ElementNoSuch {@link WebElementsActions#input(String, String)}
     *                       {@link WebElementsActions#moveToElementAndClick(String, String)}
     */
    public void inputMobile(String phone) throws ElementNoSuch {

        // TODO

    }

}
