package com.ngo.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@ToString
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Mid;
	private String FullName;
	private String FatherName;
//	private byte[] dp;
	public Member(String fullName, String fatherName) {
		super();
		FullName = fullName;
		FatherName = fatherName;
	}

	
}
