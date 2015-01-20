package me.yanaga.dne.app.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CepController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
