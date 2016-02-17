package pages;

import utils.WebDriverWrapper;
import utils.WebElementsActions;

public class Ellos {

    public WebElementsActions web;
    public HomePage homePage;
    public LoginPage loginPage;
    public ProductPage productPage;
    public CheckoutPage checkoutPage;
    public RegistrationPage registrationPage;
//    public MyCabinetPage mycabinetPage;
//    public ScreenShotMaker screenShotMaker;
//    public Mock mock;

    public Ellos(WebDriverWrapper driverWrapper) {

        web = new WebElementsActions(driverWrapper);

        homePage = new HomePage(driverWrapper);
        loginPage = new LoginPage(driverWrapper);
        productPage = new ProductPage(driverWrapper);
        checkoutPage = new CheckoutPage(driverWrapper);
        registrationPage = new RegistrationPage(driverWrapper);
        //mycabinetPage = new MyCabinetPage(driverWrapper);
        //screenShotMaker = new ScreenShotMaker(driverWrapper);
        //mock = new Mock(driverWrapper);

    }

}
