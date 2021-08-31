package com.quardio.temperature.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.quardio.temperature.dto.TemperatureDto;

/**
 * The Interface TemperatureService.
 */
public interface TemperatureService {
	
	/**
	 * Save temperature.
	 *
	 * @param temperature the temperature
	 */
	public void saveTemperature(TemperatureDto temperatureDto);

	/**
	 * Gets the aggregate data.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the aggregate data
	 */
	public Map<LocalDate, Map<Integer, Double>> getAggregateData(LocalDateTime startTime, LocalDateTime endTime);
}
