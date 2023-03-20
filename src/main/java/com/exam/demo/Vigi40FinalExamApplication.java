package com.exam.demo;

import com.exam.demo.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Vigi40FinalExamApplication {

	@Autowired
	private PlayerService playerService;

	public static void main(String[] args) {
		SpringApplication.run(Vigi40FinalExamApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void test() {

		this.playerService.loadTestData();
		this.playerService.printPlayers();

	}

}
