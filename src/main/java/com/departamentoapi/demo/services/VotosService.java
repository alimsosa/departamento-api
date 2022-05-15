package com.departamentoapi.demo.services;

import com.departamentoapi.demo.controller.PingController;
import com.departamentoapi.demo.controller.VotosController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotosService {

    private final VotosController votosController;



}
