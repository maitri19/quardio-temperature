package com.quardio.temperature.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Instantiates a new temperature dto.
 */
@Data
@ToString
@EqualsAndHashCode
public class TemperatureDto {

	/** The id. */
	private Long id;
	
	/** The device id. */
	private String deviceId;
	
	/** The temperature. */
	private Double temperature;
	
	/** The timestamp. */
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime createDate;

	/**
	 * Gets the hour.
	 *
	 * @return the hour
	 */
	public Integer findHour() {
		return getCreateDate().getHour();
	}

	/**
	 * Gets the date from dto.
	 *
	 * @return the date from dto
	 */
	public LocalDate findDateFromDto() {
		return getCreateDate().toLocalDate();
	}
	
}
