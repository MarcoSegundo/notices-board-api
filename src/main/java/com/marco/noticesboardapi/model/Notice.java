package com.marco.noticesboardapi.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="aviso")
public class Notice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "titulo")
	private String title;
	@Column(name = "descricao")
	private String description;
	@Column(name = "data_publicacao")
	private LocalDateTime publicationDate;
	@Column(name = "data_visualizacao")
	private LocalDateTime visualizationDate;
}
