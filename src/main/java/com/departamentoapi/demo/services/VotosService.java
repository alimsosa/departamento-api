package com.departamentoapi.demo.services;

import com.departamentoapi.demo.domain.VotedOkDTO;
import com.departamentoapi.demo.domain.VoteDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class VotosService {

    public VoteDTO getVotos(){
        VoteDTO votito = new VoteDTO();
        votito.setCircuito("123");
        votito.setDepartamento("montevideo");
        votito.setFecha(new Date(System.currentTimeMillis()));
        votito.setLista("lista 12");
        return votito;
    }

    public VotedOkDTO createVote(VoteDTO vote) {
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        return votedStatus;
    }
}
