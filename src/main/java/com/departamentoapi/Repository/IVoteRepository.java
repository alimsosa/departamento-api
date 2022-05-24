package com.departamentoapi.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.departamentoapi.demo.domain.VoteDTO;
import org.springframework.stereotype.Repository;
@Repository
public interface IVoteRepository extends JpaRepository<VoteDTO, Long>{

}
