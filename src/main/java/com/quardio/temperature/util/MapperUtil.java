package com.quardio.temperature.util;

import java.time.ZoneId;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quardio.temperature.dto.TemperatureDto;
import com.quardio.temperature.model.Temperature;
import com.quardio.temperature.repository.TemperatureRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class MapperUtil.
 */
@Component
public class MapperUtil {

	/** The temperature repository. */
	@Autowired
	TemperatureRepository temperatureRepository;

	/**
	 * Convert to dto.
	 *
	 * @param temperature the temperature
	 * @return the temperature dto
	 */
	public TemperatureDto convertToDto(Temperature temperature) {
		System.out.println(temperature);
		ModelMapper modelMapper = new ModelMapper();
		TemperatureDto temperatureDto = modelMapper.map(temperature, TemperatureDto.class);
//		temperatureDto
//				.setTimestamp(temperature.getCreateDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
		System.out.println(temperatureDto);
		return temperatureDto;
	}

	/**
	 * Convert to entity.
	 *
	 * @param temperatureDto the temperature dto
	 * @return the temperature
	 */
	public Temperature convertToEntity(TemperatureDto temperatureDto) {
		System.out.println(temperatureDto);
		ModelMapper modelMapper = new ModelMapper();
		Temperature temperature = modelMapper.map(temperatureDto, Temperature.class);
//		temperature.setCreateDate(java.util.Date.from(temperatureDto.getTimestamp().atZone(ZoneId.systemDefault()).toInstant()));
		System.out.println(temperature);

		return temperature;
	}
}
