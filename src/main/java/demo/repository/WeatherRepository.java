package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.model.WeatherEntity;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity ,Integer> {

}
