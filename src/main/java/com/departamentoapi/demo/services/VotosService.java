package com.departamentoapi.demo.services;

import com.departamentoapi.Repository.IVoteRepository;
import com.departamentoapi.demo.controller.RestClient;
import com.departamentoapi.demo.domain.VoteDTO;
import com.departamentoapi.demo.domain.VotedOkDTO;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
@AllArgsConstructor
public class VotosService implements IVotoRepoServices {
	
	private IVoteRepository iVoteRepository;

	public List<VoteDTO> getVotes() {
		List<VoteDTO> allVotes = new ArrayList<>();
		VoteDTO votito = new VoteDTO();
		votito.setCircuito("123");
		votito.setNombre_partido("FA");
		votito.setDepartamento("montevideo");
		votito.setFecha(new Date(System.currentTimeMillis()));
		votito.setLista("lista 12");
		VoteDTO votito2 = new VoteDTO();
		votito2.setCircuito("123");
		votito2.setDepartamento("montevideo");
		votito2.setNombre_partido("Colorado");
		votito2.setFecha(new Date(System.currentTimeMillis()));
		votito2.setLista("lista 12");
		allVotes.add(votito);
		allVotes.add(votito2);
		return allVotes;
	}

	public VotedOkDTO createVote(VoteDTO vote) {

		RestClient restClient = new RestClient();
		//restClient.callTokenApi();
		//ResponseEntity<String> call = restClient.callTokenApi();
		vote.setFecha(new Date(System.currentTimeMillis()));
		this.createVoteDTO(vote);
		VotedOkDTO votedStatus = new VotedOkDTO();
		votedStatus.setConfirmation("Voted registered");
		//votedStatus.setToken("Token utilizado para el voto: " + call.getBody());
		return votedStatus;
	}

	@Override
	public void createVoteDTO(VoteDTO VoteDTO) {
		iVoteRepository.save(VoteDTO);
	}

	@Override
	public void deleteVoteDTO(VoteDTO VoteDTO) {
		iVoteRepository.delete(VoteDTO);
	}

	@Override
	public List<VoteDTO> findAll() {
		return iVoteRepository.findAll();
	}

	@Override
	public Optional<VoteDTO> findbyId(Long id) {
		return iVoteRepository.findById(id);
	}

	@Override
	public void updateVoteDTO(VoteDTO VoteDTO) {
		iVoteRepository.save(VoteDTO);
	}

}
