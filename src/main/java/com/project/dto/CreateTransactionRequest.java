package com.project.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class CreateTransactionRequest {

  @NotNull
  @JsonProperty("transaction_id")
  private int transactionID;

  @NotNull
  @JsonProperty("table_id")
  private Integer tableID;
}
