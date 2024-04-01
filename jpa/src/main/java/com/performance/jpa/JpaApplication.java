package com.performance.jpa;

import com.github.javafaker.Faker;
import com.performance.jpa.models.Author;
import com.performance.jpa.repositories.AuthorRepository;
import com.performance.jpa.repositories.VideoRepository;
import com.performance.jpa.specification.AuthorSpecification;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

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

			for (int i = 0; i < 50; i++) {

				Faker faker = new Faker();
				var author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(19, 50))
						.email(faker.name().firstName()+"."+faker.name().lastName()+"@performance.com")
						.build();
				repository.save(author);
			}

			// update author with ID = 1

			var author = Author.builder()
					.id(1)
					.firstName("performance")
					.lastName("engineer")
					.age(32)
					.email("performance.engineer@performance.com")
					.build();
			repository.save(author);

			// update author a set a.age = 22 where a.id = 1
//			repository.updateAuthor(22, 1);

			// update all authors
//			repository.updateAllAuthors(22);



			// using Named Query
			/*repository.findByNamedQuery(30)
					.forEach(System.out::println);

			repository.updateByNamedQuery(90);*/




			/*var video = Video.builder()
					.name("abc")
					.length(5)
					.build();
			videoRepository.save(video);*/

			Specification<Author> spec = Specification
					.where(AuthorSpecification.hasAge(23))
					.and(AuthorSpecification.firstNameContains("D"));

			repository.findAll(spec).forEach(System.out::println);
		};
	}

}
