package co.sit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.sit.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}	
