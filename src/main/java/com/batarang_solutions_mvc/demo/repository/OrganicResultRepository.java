package com.batarang_solutions_mvc.demo.repository;

import com.batarang_solutions_mvc.demo.model.OrganicResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganicResultRepository extends JpaRepository<OrganicResult, Long> {
}
