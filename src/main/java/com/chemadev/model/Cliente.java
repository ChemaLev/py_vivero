package com.chemadev.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	private Integer idCliente;
	
	@Column(name = "codigo_cliente")
	private Integer codCliente;
	
	@Column(name = "nombre_cliente")
	private String nomCliente;
	
	@Column(name = "nombre_contacto")
	private String nomContacto;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "fax")
	private String fax;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "pais")
	private String pais;
	
	@Column(name = "codigo_postal")
	private String codPostal;
	
	@Column(name = "id_empleado")
	private Integer idEmpl;
	
	@Column(name = "limite_credito")
	private Double limitCred;

	@Override
	public String toString() {
		return String.format("ID_CLIENTE = %-4d, CODIGO = %-4d, NOMBRE =  %-30s, NOM_CONTACTO = %-15s, TELEFONO = %-20s, FAX = %-20s, CIUDAD = %s, REGION = %s, PAIS = %s, COD_POSTAL = %s, ID_EMPLEADO = %d,"
				+ " LIMIT CREDITO = %f", idCliente, codCliente, nomCliente, nomContacto, telefono, fax, ciudad, region, pais, codPostal, idEmpl, limitCred);
	}
	
	
}
