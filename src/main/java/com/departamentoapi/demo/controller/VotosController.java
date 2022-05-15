package com.departamentoapi.demo.controller;

import com.departamentoapi.demo.domain.VotedOkDTO;
import com.departamentoapi.demo.domain.VoteDTO;
import com.departamentoapi.demo.services.VotosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VotosController {

    private final VotosService votosService;

    @GetMapping("/getvotos")
    public ResponseEntity<VoteDTO> getVotos(@RequestBody VoteDTO voto) {
        VoteDTO response = votosService.getVotos();
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/vote")
    public ResponseEntity<VotedOkDTO> createVote(@RequestBody VoteDTO voto) {
        VotedOkDTO response = votosService.createVote(voto);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
