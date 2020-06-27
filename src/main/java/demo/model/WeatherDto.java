package demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherDto {

	 int id;

	 String main;

	 String description;

	 String icon;

	 public String toString() {
		 return main;
	 }
}
