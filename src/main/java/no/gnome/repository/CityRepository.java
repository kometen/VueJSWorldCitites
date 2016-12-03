package no.gnome.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import no.gnome.City;

public interface CityRepository extends CrudRepository<City, Long>  {
    
    List<City> findByName(String name);
}
