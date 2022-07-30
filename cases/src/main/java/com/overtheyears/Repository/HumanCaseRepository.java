package com.overtheyears.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.overtheyears.cases.entity.HumanCase;

public interface HumanCaseRepository extends JpaRepository<HumanCase, Long> {

   
}
