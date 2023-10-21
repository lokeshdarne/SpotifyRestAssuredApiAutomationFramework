package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.pojo.Playlist;
import com.spotify.oauth2.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.spotify.oauth2.api.Routes.Route.PLAYLISTS;
import static com.spotify.oauth2.api.Routes.Route.USERS;
import static com.spotify.oauth2.api.TokenManager.getToken;


/**
 * This class represents Playlist API reusable methods
 */
public class PlaylistApi {

    //static String access_token = "BQAwl5NgKeIf9DYSK00oPr9erlk3mGtgiZnjO_vcF_agUU3YA0UITVmjmStCC3rHnjz35UC7HpVBQllwYEF0DhSiUqjHK1Nn8YAf9CWBgsKm_cES0dypE5RcKhlMcs3F3iVduX0i_KATYBYVm2-C_srOsc9eg8pSqCzaLXGgt5_cx4uUVGa3xO2XzqKUw2Vsf40-SJMtTJm23prb2Ry9o2qqa4Mtu-cbagTZBN0Ikp9HetT08jQ4cWkzaA74DluhnMErvuIx-2qS";

    /**
     * Post response.
     *
     * @param requestPlaylist the request playlist
     * @return the response
     */
    @Step
    public static Response post(Playlist requestPlaylist){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId()
                + PLAYLISTS, getToken(), requestPlaylist);
    }

    /**
     * Post response.
     *
     * @param token           the token
     * @param requestPlaylist the request playlist
     * @return the response
     */
    public static Response post(String token, Playlist requestPlaylist){
        return RestResource.post(USERS + "/" + ConfigLoader.getInstance().getUserId()
                + PLAYLISTS, token, requestPlaylist);
    }

    /**
     * Get response.
     *
     * @param playlistID the playlist id
     * @return the response
     */
    public static Response get(String playlistID){

        return RestResource.get(PLAYLISTS + "/" + playlistID, getToken());
    }

    /**
     * Update response.
     *
     * @param playlistID      the playlist id
     * @param requestPlaylist the request playlist
     * @return the response
     */
    public static Response update(String playlistID, Playlist requestPlaylist){
        return RestResource.update(PLAYLISTS + "/"+ playlistID, getToken(), requestPlaylist);
    }
}

