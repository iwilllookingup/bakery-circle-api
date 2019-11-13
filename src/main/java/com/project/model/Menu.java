package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "menu")
@Entity
@Data
@Accessors(chain = true)
public class Menu implements Serializable {

  @Id
  @Column(name = "menu_id")
  @JsonProperty("menu_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int menuID;

  @Column(name = "menu_name")
  @JsonProperty("menu_name")
  private String menuName;

  private Integer price;

  private String description;

  @Column(name = "image_uri")
  @JsonProperty("image_uri")
  private String imageURI;

  private String type;
}
