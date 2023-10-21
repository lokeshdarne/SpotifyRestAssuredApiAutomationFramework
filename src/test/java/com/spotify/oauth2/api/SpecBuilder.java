package com.spotify.oauth2.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.spotify.oauth2.api.Routes.Route.BASE_PATH;

/**
 * This class represents reusable request and response specifications
 */
public class SpecBuilder {

    /**
     * Get request spec request specification.
     *
     * @return the request specification
     */
    public static RequestSpecification getRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://api.spotify.com").
                setBasePath(BASE_PATH).
                setContentType(ContentType.JSON).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    /**
     * Get account request spec request specification.
     *
     * @return the request specification
     */
    public static RequestSpecification getAccountRequestSpec(){
        return new RequestSpecBuilder().
                setBaseUri("https://accounts.spotify.com").
                setContentType(ContentType.URLENC).
                addFilter(new AllureRestAssured()).
                log(LogDetail.ALL).
                build();
    }

    /**
     * Get response spec response specification.
     *
     * @return the response specification
     */
    public static ResponseSpecification getResponseSpec(){
        return new ResponseSpecBuilder().
                        log(LogDetail.ALL).
                        build();
    }
}
