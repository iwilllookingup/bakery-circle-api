package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UpdateMenuRequest {

  @JsonProperty("menu_name")
  private String menuName;

  private Integer price;

  private String description;

  @JsonProperty("image_uri")
  private String imageURI;

  private String type;
}
