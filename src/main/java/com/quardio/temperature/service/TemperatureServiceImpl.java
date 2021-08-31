package com.quardio.temperature.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.quardio.temperature.dto.TemperatureDto;
import com.quardio.temperature.model.Temperature;
import com.quardio.temperature.repository.TemperatureRepository;
import com.quardio.temperature.util.AggregateUtil;
import com.quardio.temperature.util.MapperUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class TemperatureServiceImpl.
 */
@Service
public class TemperatureServiceImpl implements TemperatureService {

	/** The temperature repository. */
	@Autowired
	TemperatureRepository temperatureRepository;

	/** The mapper util. */
	@Autowired
	MapperUtil mapperUtil;

	/**
	 * Save temperature.
	 *
	 * @param temperature the temperature
	 */
	public void saveTemperature(TemperatureDto temperatureDto) {
		Temperature temperature = mapperUtil.convertToEntity(temperatureDto);
		temperatureRepository.save(temperature);
		
	}

	/**
	 * Gets the aggregate data.
	 *
	 * @param startTime the start time
	 * @param endTime the end time
	 * @return the aggregate data
	 */
	public Map<LocalDate, Map<Integer, Double>> getAggregateData(LocalDateTime startTime, LocalDateTime endTime) {

		List<Temperature> temperatureList = temperatureRepository.findAllByCreateDateBetween(startTime, endTime);
		
		List<TemperatureDto> temperatureDtoList = temperatureList.stream().map(a -> mapperUtil.convertToDto(a))
				.collect(Collectors.toList());

		return AggregateUtil.getDataDailyHourly(temperatureDtoList);

	}
}
