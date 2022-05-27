package com.distribuidos.deptoapi.controller;

import com.distribuidos.deptoapi.domain.CypherUtils;
import com.distribuidos.deptoapi.domain.VoteDTO;
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


    @GetMapping("/getvotes/{key}")
    public ResponseEntity<List<VoteDTO>> getVotes(@PathVariable String key) {
        return new ResponseEntity<>(votosService.getVotes(key), HttpStatus.OK);
    }

    @PostMapping("/vote")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody @Valid VoteDTO voto) throws Exception {
        VotedOkDTO response = votosService.createVote(voto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/manyvotes")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody List<VoteDTO> votos) {
        VotedOkDTO response = votosService.multipleVotes(votos);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
