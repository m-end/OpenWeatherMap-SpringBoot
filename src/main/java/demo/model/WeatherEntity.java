package demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="weather")
public class WeatherEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "city")
	private String city;

	@Column(name = "weather")
	private String weather;

	@Column(name = "temperature")
	private double temperature;

	@Column(name = "temperature_high")
	private double temperature_high;

	@Column(name = "temperature_low")
	private double temperature_low;

	@Column(name = "humidity")
	private int humidity;

	@Column(name = "pressure")
	private int pressure;

	@Column(name = "windspeed")
	private double windspeed;

	@Column(name = "date")
	private LocalDate date = LocalDate.now();

}
