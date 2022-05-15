package com.departamentoapi.demo.domain;

import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class VoteDTO {
    private String nombre_partido;
    private String lista;
    private String departamento;
    private String circuito;
    private Date fecha;
}
