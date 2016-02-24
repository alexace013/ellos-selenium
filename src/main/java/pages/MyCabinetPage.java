package pages;

import org.apache.log4j.Logger;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

public class MyCabinetPage extends Page {

    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    private static final String MAIN_PAGE = PropertyLoader.loadProperty("site.url");

    public MyCabinetPage(WebDriverWrapper driverWrapper) {

        super(driverWrapper, MAIN_PAGE);
//TODO
    }
}
