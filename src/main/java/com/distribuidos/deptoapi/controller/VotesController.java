package com.distribuidos.deptoapi.controller;

import com.distribuidos.deptoapi.domain.VoteDTO;
import com.distribuidos.deptoapi.domain.VotedOkDTO;
import com.distribuidos.deptoapi.services.VotesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class VotesController {

    private final VotesService votosService;

    @GetMapping("/getvotes")
    public ResponseEntity<List<VoteDTO>> getVotes() {
        return new ResponseEntity<>(votosService.getVotes(), HttpStatus.OK);
    }

    @PostMapping("/vote")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody VoteDTO voto) {
        VotedOkDTO response = votosService.createVote(voto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/manyvotes")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody List<VoteDTO> votos) {
        VotedOkDTO response = votosService.multipleVotes(votos);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
