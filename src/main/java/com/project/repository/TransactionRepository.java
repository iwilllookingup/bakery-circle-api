package com.project.repository;

import com.project.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
  List<Transaction> findTransactionByTableIDAndAndTotalPriceIsNull(Integer tableID);
}
