package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "admin")
@Entity
@Data
@Accessors(chain = true)
public class Admin implements Serializable {
  @Id private String username;

  private String password;

  @Column(name = "display_name")
  @JsonProperty("display_name")
  private String displayName;

  @Column(name = "first_name")
  @JsonProperty("first_name")
  private String firstName;

  @Column(name = "last_name")
  @JsonProperty("last_name")
  private String lastName;

  @Column(name = "email")
  private String email;
}
