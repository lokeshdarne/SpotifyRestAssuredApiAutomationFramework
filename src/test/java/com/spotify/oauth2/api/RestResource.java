package com.spotify.oauth2.api;

import com.spotify.oauth2.pojo.Playlist;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static com.spotify.oauth2.api.Routes.Route.API;
import static com.spotify.oauth2.api.Routes.Route.TOKEN;
import static com.spotify.oauth2.api.SpecBuilder.*;
import static io.restassured.RestAssured.given;

/**ut
 * This class represents RestAssured API reusable methods
 */
public class RestResource {

    /**
     * Post response.
     *
     * @param path            the path
     * @param token           the token
     * @param requestPlaylist the request playlist
     * @return the response
     */
    public static Response post(String path , String token, Object requestPlaylist){
        return given(getRequestSpec()).
                body(requestPlaylist).
                auth().oauth2(token).
                when().post(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    /**
     * Post account response.
     * This is being used in the Token manager.
     * @param formParams the form params
     * @return the response
     */
    public static Response postAccount(HashMap<String, String> formParams){
        return given(getAccountRequestSpec()).
                formParams(formParams).
                when().post(API + TOKEN).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    /**
     * Get response.
     *
     * @param path  the path
     * @param token the token
     * @return the response
     */
    public static Response get(String path, String token){
        return given(getRequestSpec()).
                auth().oauth2(token).
                when().get(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }

    /**
     * Update response.
     *
     * @param path            the path
     * @param token           the token
     * @param requestPlaylist the request playlist
     * @return the response
     */
    public static Response update(String path, String token, Object requestPlaylist){
        return  given(getRequestSpec()).
                auth().oauth2(token).
                body(requestPlaylist).
                when().put(path).
                then().spec(getResponseSpec()).
                extract().
                response();
    }
}

