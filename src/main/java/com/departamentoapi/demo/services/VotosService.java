package com.departamentoapi.demo.services;

import com.departamentoapi.Repository.IVoteRepository;
import com.departamentoapi.demo.controller.RestClient;
import com.departamentoapi.demo.domain.VoteDTO;
import com.departamentoapi.demo.domain.VotedOkDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VotosService /*implements IVotoRepoServices*/{

    //IVoteRepository iVoteRepository;
    private ArrayList<VoteDTO> votes;

    public List<VoteDTO> getVotes() {
        return votes;
    }

    public VotedOkDTO createVote(VoteDTO vote) {

        RestClient restClient = new RestClient();
        restClient.callTokenApi();
        ResponseEntity<String> call = restClient.callTokenApi();
        votes.add(vote);
        //createVoteDTO(vote);
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        votedStatus.setToken("Token utilizado para el voto: " + call.getBody());
        return votedStatus;
    }

    public VotedOkDTO multipleVotes(List<VoteDTO> votesReceived) {
        votesReceived.forEach(v-> votes.add(v));
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("All votes registered");
        return votedStatus;
    }

/*
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
*/
}
