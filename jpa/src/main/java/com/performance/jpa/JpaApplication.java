package com.performance.jpa;

import com.performance.jpa.models.Video;
import com.performance.jpa.repositories.AuthorRepository;
import com.performance.jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository repository,
			VideoRepository videoRepository
	) {
		return args -> {
			/*
			var author = Author.builder()
					.firstName("performance")
					.lastName("tester")
					.age(34)
					.email("performance@tester.com")
					.build();
					repository.save(author);
			*/
			var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);
		};
	}

}
