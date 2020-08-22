package demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import demo.model.OwmResponse;
import demo.model.WeatherEntity;
import demo.repository.WeatherRepository;

@Service
public class WeatherService {

	@Autowired
	private WeatherRepository weatherRepository;

	private RestTemplate restTemplate = new RestTemplate();

	public OwmResponse getResponse(String city) {
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/weather?q=" + city
						+ "&units=metric&appid={yout id }"+"&lang=ja", OwmResponse.class);
		}

	@Transactional(rollbackOn = { Exception.class })
	public WeatherEntity create(OwmResponse owmResponse) {
		WeatherEntity weatherEntity = new WeatherEntity();

		weatherEntity.setCity(owmResponse.getName());
		weatherEntity.setWeather(owmResponse.getList().toString());
		weatherEntity.setTemperature(owmResponse.getMainDto().getTemp());
		weatherEntity.setTemperature_high(owmResponse.getMainDto().getTemp_max());
		weatherEntity.setTemperature_low(owmResponse.getMainDto().getTemp_min());
		weatherEntity.setHumidity(owmResponse.getMainDto().getHumidity());
		weatherEntity.setPressure(owmResponse.getMainDto().getPressure());
		weatherEntity.setWindspeed(owmResponse.getWindDto().getSpeed());
		return weatherRepository.save(weatherEntity);

	}

	@Transactional(rollbackOn = { Exception.class })
	public List<WeatherEntity> getWeather() {
		return weatherRepository.findAll();
	}

}
