package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "orders")
@Entity
@Data
@Accessors(chain = true)
public class Orders implements Serializable {

  @Id
  @Column(name = "order_id")
  @JsonProperty("order_id")
  private int orderID;

  @Column(name = "menu_id")
  @JsonProperty("menu_id")
  private Integer menuID;

  @Column(name = "menu_name")
  @JsonProperty("menu_name")
  private String menuName;

  @Column(name = "transaction_id")
  @JsonProperty("transaction_id")
  private Integer transactionID;

  private Integer quantity;

  @Column(name = "menu_price")
  @JsonProperty("menu_price")
  private Integer menuPrice;

  @Column(name = "is_completed")
  @JsonProperty("is_completed")
  private boolean isCompleted;
}
