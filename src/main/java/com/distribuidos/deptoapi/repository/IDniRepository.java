package com.distribuidos.deptoapi.repository;

import com.distribuidos.deptoapi.domain.DniDTO;
import com.distribuidos.deptoapi.domain.VoteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDniRepository extends JpaRepository<DniDTO, Long> {
}