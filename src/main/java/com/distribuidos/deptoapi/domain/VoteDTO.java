package com.distribuidos.deptoapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "votos")
public class VoteDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombrePartido")
    private String nombre_partido;
    @Column(name = "lista")
    private String lista;
    @Column(name = "idDepartamento")
    private String departamento;
    @Column(name = "idCircuito")
    private String circuito;
    private Date fecha;
}
