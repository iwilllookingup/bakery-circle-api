package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class CreateOrderRequest {
//
//  @NotNull
//  @JsonProperty("order_id")
//  private int orderID;

  @NotNull
  @JsonProperty("menu_id")
  private Integer menuID;

  @NotNull
  @JsonProperty("menu_name")
  private String menuName;

  @NotNull
  @JsonProperty("transaction_id")
  private Integer transactionID;

  @NotNull
  private Integer quantity;

  @NotNull
  @JsonProperty("menu_price")
  private Integer menuPrice;
}
