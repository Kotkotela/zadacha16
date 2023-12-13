package com.example.restdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class MainController {
	private final PersonService service;

	@Autowired
	public MainController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/persons")
	public Iterable<Person> getPersons() {
		return service.getPersons();
	}

	@GetMapping("/persons/{personId}")
	public Optional<Person> findPersonById(@PathVariable int personId) {
		return service.findPersonById(personId);
	}

	@PostMapping("/persons")
	public Person addPerson(@RequestBody Person person) {
		return service.addPerson(person);
	}

	@PutMapping("/persons/{personId}")
	public ResponseEntity<Person> updatePerson(@PathVariable int personId, @RequestBody Person person) {
		return service.updatePerson(personId, person);
	}

	@DeleteMapping("/persons/{personId}/messages/{messageId}")
	public ResponseEntity<?> deleteMessage(@PathVariable int personId, @PathVariable int messageId) {
		return service.deleteMessage(personId, messageId);
	}

	@PostMapping("/persons/{personId}/messages")
	public ResponseEntity<?> addMessage(@PathVariable int personId, @RequestBody Message message) {
		return service.addMessage(personId, message);
	}

	@GetMapping("/persons/{personId}/messages")
	public ResponseEntity<?> getMessageList(@PathVariable int personId) {
		return service.getMessageList(personId);
	}
}