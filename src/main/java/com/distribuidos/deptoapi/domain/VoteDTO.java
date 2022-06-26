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
    @Column(name = "nombre_partido")
    @NotBlank(message = "Required: nombre_partido")
    @NotEmpty(message = "Required: nombre_partido")
    private String nombre_partido;
    @Column(name = "lista",length = 2000)
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
    @Column(name = "fecha")
    private Date fecha;
    @NotNull( message = "El dni no puede ser null")
    private Long dni;
}

