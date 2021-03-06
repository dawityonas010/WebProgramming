package com.webProject.school.domains;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@Entity
@NoArgsConstructor(access=AccessLevel.PUBLIC, force=true)
//@RequiredArgsConstructor
public class SubjectRegistration {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name ="subject_id")
	@NotNull(message="select a subject!")
	private Subject subject;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	@NotNull(message="select a student!")
	private Student student;
	
	private Date registratedAt;
	

	@NotNull( message="Grade can not be empty!")
	private double grade;
	
	@PrePersist
	void registratedAt() {
	    this.registratedAt = new Date();
	  }
	
}
