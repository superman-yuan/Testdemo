package com.yjlc.test.entity;


import com.yjlc.test.util.PropertiesReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * Created by lenovo on 2019/2/17.
 */
@ConfigurationProperties(prefix = "left")
public class HairFactory {

    private String left ;
    /**
     * 使用反射机制创建实例
     * @param key
     * @return
     */
    public HeadInterface getHair(String key){
        try {

            HeadInterface hair = (HeadInterface) Class.forName(key).newInstance();
            return hair;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
