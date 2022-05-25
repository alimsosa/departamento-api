package com.distribuidos.deptoapi.repository;

import com.distribuidos.deptoapi.domain.VoteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotesRepository extends JpaRepository<VoteDTO, Long> {
}
