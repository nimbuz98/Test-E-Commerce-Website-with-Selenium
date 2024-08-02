package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataClass {
    Properties pro;

    // Constructor

    public ConfigDataClass(){

        //Pass the location of the properties file which contain configuration data
        File src = new File("./configurations/config.properties");

        try{
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String getBrowser(){
        return pro.getProperty("browser");
    }

    public String getUrl(){
        return pro.getProperty("url");
    }
}
