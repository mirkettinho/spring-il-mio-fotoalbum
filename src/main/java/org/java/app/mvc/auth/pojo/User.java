package org.java.app.mvc.auth.pojo;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "users")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false, unique = true)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	
	public User() {}
	
	public User(String username, String password, Role... roles) {
		
		setUsername(username);
		setPassword(password);
		setRoles(Arrays.asList(roles));
	}
	
	/// GET & SET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	@Override
	public String toString() {
		return "[" + getId() + "]" + getUsername();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(
									r.getName()
								)
				).toList();
	}

	@Override 
	public boolean isAccountNonExpired() { 
		return true; 
	}
	@Override 
	public boolean isAccountNonLocked() { 
		return true; 
	}
	@Override 
	public boolean isCredentialsNonExpired() { 
		return true; 
	}
	@Override 
	public boolean isEnabled() { 
		return true; 
	}
	
}