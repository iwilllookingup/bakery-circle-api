package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class CreateMenuRequest {

    @NotNull
    @JsonProperty("menu_name")
    private String menuName;

    @NotNull
    private Integer price;

    private String description;

    @JsonProperty("image_uri")
    private String imageURI;

    @NotNull
    private String type;
}
