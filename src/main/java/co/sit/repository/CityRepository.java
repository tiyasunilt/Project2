package co.sit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.sit.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {

	List<City> findByStateId(Integer stateId);

}
