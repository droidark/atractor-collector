package io.atractor.comic.collector.domain.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "salary")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salary {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "salary_generator")
	@SequenceGenerator(name = "salary_generator", sequenceName = "salary_seq", allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@Column(name = "salary")
	private double salary;
	
	@Column(name = "from_date")
	private Date fromDate;
	
	@Column(name = "to_date")
	private Date toDate;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "emp_no")
	private Employee employee;

}
