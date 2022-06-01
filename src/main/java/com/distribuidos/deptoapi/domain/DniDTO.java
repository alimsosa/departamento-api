package com.distribuidos.deptoapi.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "cedulas")
public class DniDTO {
    @Id
    Long dni;
}
