package com.quardio.temperature.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;

import lombok.Data;

/**
 * The Class Temperature.
 */
@Entity
@Table(name = "Temperature")

/**
 * Instantiates a new temperature.
 */
@Data
public class Temperature implements Serializable {

	/** The id. */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	/** The device id. */
	private String deviceId;
	
	/** The temperature. */
	private Double temperature;
	
	/** The create date. */
	@Column(columnDefinition = "TIMESTAMP")
	private LocalDateTime createDate;

}
