package com.javatechie.multiple.ds.api.model.user_db2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_TB")
public class User {
	@Id
	private int id;
	private String userName;
}
