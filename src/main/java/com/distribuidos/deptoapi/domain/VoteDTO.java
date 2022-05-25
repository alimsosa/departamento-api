package com.distribuidos.deptoapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Getter
@Setter
@Entity
@Table(name = "votos")
public class VoteDTO {
    @Id
    @Column(name = "id")
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
