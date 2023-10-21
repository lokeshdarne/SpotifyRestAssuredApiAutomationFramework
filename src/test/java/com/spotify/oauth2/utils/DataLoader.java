package com.spotify.oauth2.utils;

import java.util.Properties;

/**
 * This class represents Singleton data.properties reader
 */
public class DataLoader {
    private final Properties properties;
    private static DataLoader dataLoader;

    private DataLoader(){
        properties = PropertyUtils.propertyLoader("src/test/resources/data.properties");
    }

    /**
     * Get instance data loader.
     *
     * @return the data loader
     */
    public static DataLoader getInstance(){
        if(dataLoader == null){
            dataLoader = new DataLoader();
        }
        return dataLoader;
    }

    /**
     * Get get playlist id string.
     *
     * @return the string
     */
    public String getGetPlaylistID(){
        String prop = properties.getProperty("get_playlist_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_playlist_id is not specified in the config.properties file");
    }

    /**
     * Get update playlist id string.
     *
     * @return the string
     */
    public String getUpdatePlaylistId(){
        String prop = properties.getProperty("get_update_playlist_id");
        if(prop != null) return prop;
        else throw new RuntimeException("property get_update_playlist_id is not specified in the config.properties file");
    }
}
