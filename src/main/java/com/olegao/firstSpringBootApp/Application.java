package com.olegao.firstSpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	static String xmlFilePath;
	public static void main(String[] args) {
	    if (args.length != 0) {
			xmlFilePath = args[0];
		}
		else {
			xmlFilePath = "books.xml";
		}
        SpringApplication.run(Application.class, args);
	}
}
