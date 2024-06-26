package com.batarang_solutions_mvc.demo.repository;

import com.batarang_solutions_mvc.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
