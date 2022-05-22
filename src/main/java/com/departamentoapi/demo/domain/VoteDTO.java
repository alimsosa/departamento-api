package com.departamentoapi.demo.domain;

import lombok.*;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "partido")
public class VoteDTO {
	
	@Column(name = "idPartido")
    private String id_partido;
	@Column(name = "nombrePartido")
    private String nombre_partido;
	@Column(name = "idLista")
    private String lista;
	@Column(name = "idDepartamento")
    private String departamento;
	@Column(name = "idCircuito")
    private String circuito;
	
    private Date fecha;
    
	public String getLista() {
		return lista;
	}
	public void setLista(String lista) {
		this.lista = lista;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getNombre_partido() {
		return nombre_partido;
	}
	public void setNombre_partido(String nombre_partido) {
		this.nombre_partido = nombre_partido;
	}
	public String getCircuito() {
		return circuito;
	}
	public void setCircuito(String circuito) {
		this.circuito = circuito;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
