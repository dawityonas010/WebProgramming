package com.webProject.school.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
public class Attendance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date attendanceDate;
	
	@ManyToOne
	@JoinColumn(name ="student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name ="subject_id")
	private Subject subject;
	
	private String status;
	
	@PrePersist
	void placedAt() {
		this.attendanceDate = new Date();
	}	
}