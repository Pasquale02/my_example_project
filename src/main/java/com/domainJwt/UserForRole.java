package com.domainJwt;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.google.gson.GsonBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author FLORIOP
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserForRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String username;
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles;

	@Override
	public String toString() {
		return new GsonBuilder().create().newBuilder().setPrettyPrinting().create().toJson(this);
	}
}
