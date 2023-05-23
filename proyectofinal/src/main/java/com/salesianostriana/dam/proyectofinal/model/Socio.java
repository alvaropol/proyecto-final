package com.salesianostriana.dam.proyectofinal.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Socio implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String nombre, apellidos, dni;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;

	private String direccion, telefono, email,username, password;
	private boolean socioRojo;
	
	@Builder.Default
	private int cantidadCompras=0; //Si el socio supera las 5 compras, pasará a ser un socio rojo

	@Lob
	private String imagen;
	
	private boolean admin;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "socio", 
	           fetch = FetchType.EAGER,
	           cascade = CascadeType.REMOVE, //Si se elimina un socio, todas sus ventas también se borraran. (Ya que no nos interesa tener las compras de un antiguo socio, por el espacio de la base de datos)
	           orphanRemoval = true)
	@Builder.Default
	private List<Venta> listaVentas = new ArrayList<>();
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (admin) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	


	public boolean isAccountNonExpired() {
		return true;
	}


	public boolean isAccountNonLocked() {
		return true;
	}

	
	public boolean isCredentialsNonExpired() {
		return true;
	}


	public boolean isEnabled() {
		return true;
	}
}
