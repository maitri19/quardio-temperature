package com.quardio.temperature.util;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.quardio.temperature.dto.TemperatureDto;

// TODO: Auto-generated Javadoc
/**
 * The Class AggregateUtil.
 */
public class AggregateUtil {



/**
 * Gets the temerature data daily and hourly.
 *
 * @param listOfTemp the list of temp
 * @return the databy days
 */
public static Map<LocalDate, Map<Integer, Double>> getDataDailyHourly(List<TemperatureDto> listOfTemp) {

		Map<LocalDate, Map<Integer, Double>> averageTempPerDayPerHour = listOfTemp.stream().collect(
				Collectors.groupingBy(TemperatureDto::findDateFromDto, Collectors.groupingBy(TemperatureDto::findHour,
						Collectors.averagingDouble(TemperatureDto::getTemperature))));

		return averageTempPerDayPerHour;

	}

}
