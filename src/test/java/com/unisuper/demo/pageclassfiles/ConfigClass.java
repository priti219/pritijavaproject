package com.unisuper.demo.pageclassfiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pritig on 15/06/2017.
 */
public class ConfigClass {

    public static Properties returnProp(){
        Properties prop = new Properties();
        InputStream input = null;

        try{
            //input = ConfigClass.class.getClassLoader().getResourceAsStream("src\\main\\java\\resources\\config.properties");

            input = new FileInputStream("src/main/java/resources/config.properties");
            prop.load(input);

            prop.getProperty("website_url");
            prop.getProperty("browser");

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (input != null){
                try{
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
