package com.formacionbdi.springboot.app.commons.usuarios.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Class Usuario. Se serializa la clase. Esto es si la clase se utiliza de forma
 * remota o cuando se necesita guardar en una sesion http.
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@ToString
public class Usuario implements Serializable {

	/**
	 * Constant Serializable.
	 */
	private static final long serialVersionUID = 4002221912401133094L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * The User Name.
	 */
	@Column(unique = true, length = 20)
	private String username;

	/**
	 * The Password.
	 */
	@Column(length = 60)
	private String password;

	/**
	 * The Enabled.
	 */
	private Boolean enabled;

	/**
	 * The Nombre.
	 */
	private String nombre;

	/**
	 * The Apellido.
	 */
	private String apellido;

	/**
	 * The Email
	 */
	@Column(unique = true, length = 100)
	private String email;

	/**
	 * The Roles. Representa la relación de muchos a muchos.
	 * 
	 * @JoinTable sirve para customizar la tabla que se genera de muchos a muchos.
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usuarios_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "role_id"), uniqueConstraints = {
			@UniqueConstraint(columnNames = { "usuario_id", "role_id" }) })
	private List<Role> roles;

	private Integer intentos;

}
