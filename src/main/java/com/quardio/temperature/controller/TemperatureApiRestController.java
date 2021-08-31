package com.quardio.temperature.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.validation.ValidationException;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quardio.temperature.dto.TemperatureDto;
import com.quardio.temperature.exception.InvalidRequestException;
import com.quardio.temperature.service.TemperatureService;
import com.quardio.temperature.service.TemperatureServiceImpl;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * The Class TemperatureApiRestController.
 */
@RestController
@EnableSwagger2
@RequestMapping("/temperature")
public class TemperatureApiRestController {

	/** The temperature service impl. */
	@Autowired
	TemperatureService temperatureService;

	/**
	 * Save temperature.
	 *
	 * @param temperature the temperature
	 * @return the response entity
	 */
	@PostMapping("/create")
	public ResponseEntity<String> saveTemperature(@RequestBody @Validated TemperatureDto temperatureDto) {
		if (temperatureDto != null) {
			temperatureService.saveTemperature(temperatureDto);
			return new ResponseEntity<String>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Gets the temperature date.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @param isHourly the is hourly
	 * @return the temperature date
	 */
	@GetMapping("/retrieve")
	public ResponseEntity<Map<LocalDate, Map<Integer, Double>>> getTemperaturesDailyHourly(
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull LocalDateTime startTime,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @NotNull LocalDateTime endTime) {
		
		if(endTime.isBefore(startTime)) {
			throw new InvalidRequestException("Start date can not be after end date.");
		}
		return ResponseEntity.ok().body(temperatureService.getAggregateData(startTime, endTime));
	}

}
