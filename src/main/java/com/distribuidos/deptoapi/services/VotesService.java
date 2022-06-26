package com.distribuidos.deptoapi.services;

import com.distribuidos.deptoapi.domain.CypherEncrypter;
import com.distribuidos.deptoapi.domain.DniDTO;
import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VotedOkDTO;
import com.distribuidos.deptoapi.repository.IDniRepository;
import com.distribuidos.deptoapi.repository.IVotesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class VotesService {

    @Autowired
    IVotesRepository iVoteRepository;

    @Autowired
    IDniRepository dniRepository;

    public List<VoteDTO> getVotes() {
        return iVoteRepository.findAll();
    }

    public VotedOkDTO createVote(VoteDTO vote) throws Exception {
        validate(vote);
        vote.setFecha(new Date(System.currentTimeMillis()));
        this.encryptVote(vote);
        iVoteRepository.save(vote);
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("Voted registered");
        return votedStatus;
    }

    private void validate(VoteDTO vote) throws Exception {
        Optional<DniDTO> isInDB = dniRepository.findById(vote.getDni());
        if (!isInDB.isEmpty()) {
            throw new Exception("DNI ya registrada");
        }
        DniDTO dni = new DniDTO();
        dni.setDni(vote.getDni());
        dniRepository.save(dni);
    }


    public VotedOkDTO multipleVotes(List<VoteDTO> votesReceived) {
        iVoteRepository.saveAll(votesReceived);
        for(VoteDTO vote : votesReceived){
            DniDTO dni = new DniDTO();
            dni.setDni(vote.getDni());
            dniRepository.save(dni);
        }
        VotedOkDTO votedStatus = new VotedOkDTO();
        votedStatus.setConfirmation("All votes registered");
        return votedStatus;
    }
    private void encryptVote(VoteDTO vote) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, IOException, InvalidKeySpecException, InvalidKeyException {
        vote.setNombre_partido(CypherEncrypter.encrypt(vote.getNombre_partido().getBytes()));
        vote.setLista(CypherEncrypter.encrypt(vote.getLista().getBytes()));
    }
}