package com.example.DataCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class DataCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataCollectionApplication.class, args);
	}

}
