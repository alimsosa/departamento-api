package com.distribuidos.deptoapi.repository;

import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VoteToSaveDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVotesRepository extends JpaRepository<VoteToSaveDTO, Long> {
}
