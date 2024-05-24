package com.batarang_solutions_mvc.demo.repository;

import com.batarang_solutions_mvc.demo.model.PublicationInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationInfoRepository extends JpaRepository<PublicationInfo, Long> {
}
