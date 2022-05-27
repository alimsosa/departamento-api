package com.distribuidos.deptoapi.services;

import com.distribuidos.deptoapi.domain.CypherUtils;
import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VotedOkDTO;
import com.distribuidos.deptoapi.repository.IVotesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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

        vote.setEncryptLista(CypherUtils.encryptString(vote.getLista()));
        System.out.println(CypherUtils.decrypt(vote.getEncryptLista()));
        vote.setEncryptIdDepartamento(CypherUtils.encryptString(vote.getDepartamento()));
        System.out.println(CypherUtils.decrypt(vote.getEncryptIdDepartamento()));
        vote.setEncryptIdCircuito(CypherUtils.encryptString(vote.getCircuito()));
        System.out.println(CypherUtils.decrypt(vote.getEncryptLista()));
        vote.setEncryptNombrePartido(CypherUtils.encryptString(vote.getNombre_partido()));
        System.out.println(CypherUtils.decrypt(vote.getEncryptNombrePartido()));

        insertEncryptedInDB(vote);
        iVoteRepository.save(vote);

        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        return votedStatus;
    }

    private void insertEncryptedInDB(VoteDTO vote) {
        // crear un nuevo objeto que sera el que se guarde en vez de VoteDTO por ejemplo, una entidad VoteCypher voteCypher

        /*
        aca setear los datos de la entidad encryptados
        voteCypher.setEncryptLista(CypherUtils.encryptString(vote.getLista()));
        voteCypher.setEncryptIdDepartamento(CypherUtils.encryptString(vote.getDepartamento()));
        voteCypher.setEncryptIdCircuito(CypherUtils.encryptString(vote.getCircuito()));
        voteCypher.setEncryptNombrePartido(CypherUtils.encryptString(vote.getNombre_partido()));
        vote.setEncryptToken(CypherUtils.encryptString(vote.getToken()));
        // IVoteRepository.save(voteCypher)

         */
    }

    private void validate(VoteDTO vote) throws Exception {/*
        String token = vote.getToken();
        RestClient restClient = new RestClient();
        restClient.callTokenApi();
        ResponseEntity<String> call = restClient.callTokenApi();
        if(token.equals(call.getBody()))
            return;
        else
            throw new Exception("El token no coincide");*/
    }

    public VotedOkDTO multipleVotes(List<VoteDTO> votesReceived) {
        iVoteRepository.saveAll(votesReceived);
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("All votes registered");
        return votedStatus;
    }

}
