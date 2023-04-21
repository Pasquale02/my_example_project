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
@Table(name = "actor")
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

	@Id
	Integer actor_id;
	String first_name;
	String last_name;
	String last_update;
}
