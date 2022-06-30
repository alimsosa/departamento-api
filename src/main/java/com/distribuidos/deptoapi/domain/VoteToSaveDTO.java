package com.distribuidos.deptoapi.domain;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name = "votos")
public class VoteToSaveDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombre_partido")
    @NotBlank(message = "Required: nombre_partido")
    @NotEmpty(message = "Required: nombre_partido")
    private String nombre_partido;
    @Column(name = "lista")
    @NotBlank(message = "Required: lista")
    @NotEmpty(message = "Required: lista")
    private String lista;
    @Column(name = "departamento")
    @NotBlank(message = "Required: departamento")
    @NotEmpty(message = "Required: departamento")
    private String departamento;
    @Column(name = "circuito")
    @NotBlank(message = "Required: circuito")
    @NotEmpty(message = "Required: circuito")
    private String circuito;
}