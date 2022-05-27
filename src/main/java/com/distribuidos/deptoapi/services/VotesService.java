package com.distribuidos.deptoapi.services;

import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VotedOkDTO;
import com.distribuidos.deptoapi.repository.IVotesRepository;
import com.distribuidos.deptoapi.restclient.RestClient;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor @NoArgsConstructor
public class VotesService {

    @Autowired
    IVotesRepository iVoteRepository;

    public List<VoteDTO> getVotes(String key) {
        return iVoteRepository.findAll();
    }

    public VotedOkDTO createVote(VoteDTO vote) throws Exception {
        //validate(vote);
        vote.setFecha(new Date(System.currentTimeMillis()));
        iVoteRepository.save(vote);
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        return votedStatus;
    }

/*    private void validate(VoteDTO vote) throws Exception {
        String token = vote.getToken();
        RestClient restClient = new RestClient();
        restClient.callTokenApi();
        ResponseEntity<String> call = restClient.callTokenApi();
        if(token.equals(call.getBody()))
            return;
        else
            throw new Exception("El token no coincide");
    }*/

    public VotedOkDTO multipleVotes(List<VoteDTO> votesReceived) {
        iVoteRepository.saveAll(votesReceived);
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("All votes registered");
        return votedStatus;
    }

}
