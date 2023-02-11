package io.atractor.comic.collector.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.atractor.comic.collector.domain.model.Publisher;
import io.atractor.comic.collector.domain.repository.PublisherRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/publishers")
@AllArgsConstructor
public class PublisherController {
	
	private PublisherRepository publisherRepository;
	
	@GetMapping
	public Iterable<Publisher> retrieveAllPublishers() {
		return publisherRepository.findAll();
	}
	
	@PostMapping
	public Publisher savePublisher(@RequestBody Publisher publisher) {
		return publisherRepository.save(publisher);
	}

}
