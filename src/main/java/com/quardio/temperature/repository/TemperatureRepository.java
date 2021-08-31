package com.quardio.temperature.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quardio.temperature.model.Temperature;

/**
 * The Interface TemperatureRepository.
 */
@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

	/**
	 * Find all by create date between.
	 *
	 * @param start the start
	 * @param end the end
	 * @return the list
	 */
	List<Temperature> findAllByCreateDateBetween(LocalDateTime start, LocalDateTime end);
	
	
}
