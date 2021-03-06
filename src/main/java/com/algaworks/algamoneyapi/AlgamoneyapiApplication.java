package com.algaworks.algamoneyapi;

import com.algaworks.algamoneyapi.config.property.AlgamoneyApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AlgamoneyApiProperty.class)
public class AlgamoneyapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgamoneyapiApplication.class, args);
	}

}
