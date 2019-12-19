package com.yjlc.test.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by lenovo on 2019/2/17.
 */
public class PropertiesReader {
    public Map<String,String> getProperties() {
        Properties properties = new Properties();
        Map<String,String> map = new HashMap<String,String>();
        try {
            InputStream inputStream = getClass().getResourceAsStream("type.properties");
            properties.load(inputStream);
            Enumeration enumeration = properties.propertyNames();
            while(enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String property = properties.getProperty(key);
                map.put(key,property);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
