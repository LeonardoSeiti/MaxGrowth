package br.com.fiap.MaxGrowth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@EnableCaching
@SpringBootApplication
@Controller
@OpenAPIDefinition(
	info = @Info(
		title = "Max Growth API",
		 version = "1.0",
		  description = "Documentação da API Max Growth",
		   contact = @Contact(name = "Leonardo Seiti or Kelvin Gomes", email = "Max@supplements.com")

))

public class MaxGrowthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaxGrowthApplication.class, args);
	}

	@RequestMapping
	@ResponseBody
	public String home() {
		return "WepApp Max Growth";
	}

}
