package com.formacionbdi.springboot.app.commons.usuarios.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class Role. Se serializa la clase. Esto es si la clase se utiliza de forma
 * remota o cuando se necesita guardar en una sesion http.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@ToString
public class Role implements Serializable {

	/**
	 * Constant Serializable.
	 */
	private static final long serialVersionUID = 4467531611801172710L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 30)
	private String nombre;

}
