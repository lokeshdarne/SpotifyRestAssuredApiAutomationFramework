package com.spotify.oauth2.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
// we can also use @Data and @Value instead of getter and setter
@Jacksonized
@Builder
public class InnerError {

    @JsonProperty("status")
    private Integer status;
    @JsonProperty("message")
    private String message;
}
