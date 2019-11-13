package com.project.repository;

import com.project.model.BakeryTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BakeryTableRepository extends JpaRepository<BakeryTable, Integer> {
//  BakeryTable findBakeryTableByStatus(String status);
}
