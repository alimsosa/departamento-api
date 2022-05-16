package com.departamentoapi.demo.services;

import com.departamentoapi.demo.domain.VotedOkDTO;
import com.departamentoapi.demo.domain.VoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VotosService {

    public List<VoteDTO> getVotes(){
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
        vote.setFecha(new Date(System.currentTimeMillis()));
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        return votedStatus;
    }
}
