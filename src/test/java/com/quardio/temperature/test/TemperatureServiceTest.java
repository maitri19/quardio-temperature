package com.quardio.temperature.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.quardio.temperature.dto.TemperatureDto;
import com.quardio.temperature.model.Temperature;
import com.quardio.temperature.repository.TemperatureRepository;
import com.quardio.temperature.service.TemperatureService;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(
		  locations = "classpath:application-test.properties")
public class TemperatureServiceTest {

	@Autowired
    private TemperatureService temperatureService;
	
	@Autowired
	private TemperatureRepository temperatureRepository;
	
	@Test
    public void shouldCreateTemperatureRecord(){
		
		TemperatureDto dto= new TemperatureDto();
		dto.setCreateDate(LocalDateTime.of(2021, Month.APRIL, 4,17,04,20));
		dto.setDeviceId("111");
		dto.setTemperature(40.50d);
		long numOfRecords=temperatureRepository.count();
		temperatureService.saveTemperature(dto);
		assertEquals(temperatureRepository.count(),numOfRecords+1);
		
	}
	
	@Test
    public void shouldRetrieveTemperaturesForOneDateHourly(){
		
		LocalDateTime startTime = LocalDateTime.of(2021, Month.AUGUST, 25, 5, 25);
		LocalDateTime endTime = LocalDateTime.of(2021, Month.AUGUST, 25, 9, 8);
		
		Map<LocalDate, Map<Integer, Double>> temperatureMap = temperatureService.getAggregateData(startTime, endTime);
		
		//Iterator iterator=temperatureMap.keySet().iterator();
		LocalDate date=LocalDate.of(2021, Month.AUGUST, 25);
		Map<Integer,Double> hourlyTempMap=temperatureMap.get(date);
		assertEquals(hourlyTempMap.get(6),25.3);
		assertEquals(hourlyTempMap.get(7),20);
		assertEquals(hourlyTempMap.get(8),15.5);
		assertEquals(hourlyTempMap.get(9),11.3);
	}
	
	@Test
    public void shouldRetrieveTemperaturesForDateRangeHourly(){
		
		LocalDateTime startTime = LocalDateTime.of(2021, Month.AUGUST, 25, 6, 25);
		LocalDateTime endTime = LocalDateTime.of(2021, Month.AUGUST, 30, 9, 8);
		
		Map<LocalDate, Map<Integer, Double>> temperatureMap = temperatureService.getAggregateData(startTime, endTime);
		assertEquals(temperatureMap.keySet().size(),3);
		LocalDate date=temperatureMap.keySet().iterator().next();
		Map<Integer,Double> hourlyTempMap=temperatureMap.get(date);
		assertEquals(hourlyTempMap.get(21),25.3);
		assertEquals(hourlyTempMap.get(22),20.3);
		assertEquals(hourlyTempMap.get(23),11.3);
		
		
	}
	
	
}
