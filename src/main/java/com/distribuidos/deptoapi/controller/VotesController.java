package com.distribuidos.deptoapi.controller;

import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VoteToSaveDTO;
import com.distribuidos.deptoapi.domain.VotedOkDTO;
import com.distribuidos.deptoapi.services.VotesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
public class VotesController {

    private final VotesService votosService;


    @GetMapping("/getvotes")
    public ResponseEntity<List<VoteToSaveDTO>> getVotes() {
        return new ResponseEntity<>(votosService.getVotes(), HttpStatus.OK);
    }

    @PostMapping("/vote")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody @Valid VoteDTO voto) throws Exception {
        VotedOkDTO response = votosService.createVote(voto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
