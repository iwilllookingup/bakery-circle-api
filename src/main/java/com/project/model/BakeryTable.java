package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@javax.persistence.Table(name = "bakery_table")
@Entity
@Data
@Accessors(chain = true)
public class BakeryTable implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "table_id")
  @JsonProperty("table_id")
  private Integer tableID;

  private String status;

  private String location;
}
