package utils;

import constants.Constant;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {

    /**
     * This method is used to read the property name from the property file
     * @param property - property name
     * @return - property value
     */
    public static String getProperty(String property) {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(Constant.CONFIGPATH));
            return prop.getProperty(property);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
