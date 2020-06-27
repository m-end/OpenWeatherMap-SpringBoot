package demo.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwmResponse {

	private Integer id;

	private String name;

	@JsonProperty("main")
	private MainDto mainDto;

	@JsonProperty("weather")
	private List<WeatherDto> list = new ArrayList<>();

	@JsonProperty("wind")
	private WindDto windDto;

	@JsonProperty("sys")
	private SysDto sysDto;

}
