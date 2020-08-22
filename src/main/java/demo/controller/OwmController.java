package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import demo.model.OwmResponse;
import demo.model.WeatherEntity;
import demo.service.WeatherService;

@Controller
@SessionAttributes(types = OwmResponse.class)
public class OwmController {

	@Autowired
	WeatherService weatherService;

	@RequestMapping("/")
	public String form() {
		return "inputForm";
	}

	//気象情報検索
	@PostMapping("/weather")
	public String getResponse(Model model, @RequestParam("city") String city) {
		OwmResponse owmResponse = weatherService.getResponse(city);

		model.addAttribute("owmResponse", owmResponse);
		model.addAttribute("name", owmResponse.getName());
		model.addAttribute("main", owmResponse.getMainDto());
		model.addAttribute("weather", owmResponse.getList());
		model.addAttribute("wind", owmResponse.getWindDto());
		model.addAttribute("sys", owmResponse.getSysDto());
		return "outputForm";
	}

	//保存
	@PostMapping("/weather/create")
	public String create(OwmResponse owmResponse) {
		weatherService.create(owmResponse);
		return "createForm";
	}

	//取得
	@GetMapping("/weather/create")
	public String getWeather(Model model) {
		List<WeatherEntity> list = weatherService.getWeather();
		model.addAttribute("list", list);
		return "retrieveForm";
	}

	//例外処理
	@ExceptionHandler(Exception.class)
	public String handleException(Exception e) {
		System.out.println(e.getClass().getName());
		e.printStackTrace();
		return "error";
	}

}
