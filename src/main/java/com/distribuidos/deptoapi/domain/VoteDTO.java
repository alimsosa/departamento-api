package com.distribuidos.deptoapi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "votos")
public class VoteDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "nombrePartido")
    @NotBlank(message = "Required: nombre_partido")
    @NotEmpty(message = "Required: nombre_partido")
    private String nombre_partido;
    @Column(name = "lista")
    @NotBlank(message = "Required: lista")
    @NotEmpty(message = "Required: lista")
    private String lista;
    @Column(name = "idDepartamento")
    @NotBlank(message = "Required: departamento")
    @NotEmpty(message = "Required: departamento")
    private String departamento;
    @Column(name = "idCircuito")
    @NotBlank(message = "Required: circuito")
    @NotEmpty(message = "Required: circuito")
    private String circuito;
    private Date fecha;
    @NotBlank(message = "Required: token")
    @NotEmpty(message = "Required: token")
    private String token;

    @Column(name = "encryptID")
    private byte[] encryptID;
    @Column(name = "encryptLista")
    private byte[] encryptLista;
    @Column(name = "encryptNombrePartido")
    private byte[] encryptNombrePartido;
    @Column(name = "encryptIdDepartamento")
    private byte[] encryptIdDepartamento;
    @Column(name = "encryptIdCircuito")
    private byte[] encryptIdCircuito;
    @Column(name = "encryptToken")
    private byte[] encryptToken;

}

