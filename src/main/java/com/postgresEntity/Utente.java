package com.postgresEntity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utente")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utente {

	@Id
	Integer id;
	String name;
	String username;
}
