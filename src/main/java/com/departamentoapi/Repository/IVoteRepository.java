package com.departamentoapi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.departamentoapi.demo.domain.VoteDTO;

public interface IVoteRepository extends JpaRepository<VoteDTO, Long>{
	

}
