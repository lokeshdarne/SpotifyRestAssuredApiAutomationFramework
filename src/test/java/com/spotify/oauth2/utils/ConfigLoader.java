package com.spotify.oauth2.utils;

import java.util.Properties;

/**
 * This class represents Singleton config.properties reader
 */
public class ConfigLoader {
    private final Properties properties;
    private static ConfigLoader configLoader;

    private ConfigLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    /**
     * Get instance config loader.
     *
     * @return the config loader
     */
    public static ConfigLoader getInstance(){
        if(configLoader == null){
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    /**
     * Get client id string.
     *
     * @return the string
     */
    public String getClientId(){
        String prop = properties.getProperty("client_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property client_id is not specified in the config.properties file");
    }

    /**
     * Get client secret string.
     *
     * @return the string
     */
    public String getClientSecret(){
        String prop = properties.getProperty("client_secret");
        if(prop != null) return prop;
        else throw new RuntimeException("property client_secret is not specified in the config.properties file");
    }

    /**
     * Get refresh token string.
     *
     * @return the string
     */
    public String getRefreshToken(){
        String prop = properties.getProperty("refresh_token");
        if(prop != null) return prop;
        else throw new RuntimeException("property refresh_token is not specified in the config.properties file");
    }

    /**
     * Get grant type string.
     *
     * @return the string
     */
    public String getGrantType(){
        String prop = properties.getProperty("grant_type");
        if(prop != null) return prop;
        else throw new RuntimeException("property grant_type is not specified in the config.properties file");
    }

    /**
     * Get user id string.
     *
     * @return the string
     */
    public String getUserId(){
        String prop = properties.getProperty("user_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property user_id is not specified in the config.properties file");
    }
}
