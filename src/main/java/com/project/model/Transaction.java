package com.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Table(name = "transaction")
@Entity
@Data
@Accessors(chain = true)
public class Transaction implements Serializable {

  @Id
  @Column(name = "transaction_id")
  @JsonProperty("transaction_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int transactionID;

  @Column(name = "table_id")
  @JsonProperty("table_id")
  private Integer tableID;

  @Column(name = "total_price")
  @JsonProperty("total_price")
  private Integer totalPrice;

  @Column(name = "transaction_date")
  @JsonProperty("transaction_date")
  @CreatedDate
  private Date transactionDate;
}
