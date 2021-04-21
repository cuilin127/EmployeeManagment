package com.LinCui.Beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//123
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String name;
	private String password;
	public Employee(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
}
