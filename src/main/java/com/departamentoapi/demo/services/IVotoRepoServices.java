package com.departamentoapi.demo.services;

import java.util.List;
import java.util.Optional;

import com.departamentoapi.Repository.IVoteRepository;
import com.departamentoapi.demo.domain.VoteDTO;

public interface IVotoRepoServices 
{
	void createVoteDTO(VoteDTO vote);
	 
    void deleteVoteDTO(VoteDTO vote);
    List<VoteDTO> findAll();
    Optional<VoteDTO> findbyId(Long id);
    void updateVoteDTO(VoteDTO vote);
}
