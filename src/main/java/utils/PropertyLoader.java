package utils;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader {

    //    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());
    //    private static final String PROPERTY_FILE = "/application.properties";
    private static final String PROPERTY_FILE = "/application.properties";
    private static Map propertiesMap;

    /**
     * Public static synchronized method for load property from {@value PROPERTY_FILE}
     *
     * @param name parameter to the indicate which browser will be selected as the driver
     * @return {@link String#valueOf(Object)}
     */
    public static synchronized String loadProperty(String name) {

        if (propertiesMap == null) {

            loadData();

        }

        return String.valueOf(propertiesMap.get(name));

    }

    /**
     * Private static synchronized method for load data from properties
     */
    private static synchronized void loadData() {

        Properties properties = new Properties();

        try {

            properties.load(PropertyLoader.class.getResourceAsStream(PROPERTY_FILE));
            propertiesMap = properties;


        } catch (IOException e) {

            e.printStackTrace();

        }

    }

}
