package com.postgresEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="utente")
@Getter
@Setter
@Data
public class Utente {
	
	@Id
	Integer id;
	String name;
	String username;
	String password;

}
