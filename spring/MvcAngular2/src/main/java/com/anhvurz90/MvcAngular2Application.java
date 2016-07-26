package com.anhvurz90;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.anhvurz90.database.NoteRepository;
import com.anhvurz90.database.UserRepository;
import com.anhvurz90.model.Note;
import com.anhvurz90.model.User;

@SpringBootApplication
public class MvcAngular2Application {

	public static void main(String[] args) {
		SpringApplication.run(MvcAngular2Application.class, args);
	}
	
	@Bean
	CommandLineRunner init(UserRepository userRepository, NoteRepository noteRepository) {
		return (evt) -> {
			User user = new User();
			user.setUsername("vladson");
			user.setPassword("111");
			userRepository.save(user);
			
			Note note = new Note();
			note.setUser(user);
			note.setContent("test note");
			noteRepository.save(note);
			
			User user2 = new User();
			user2.setUsername("vu");
			user2.setPassword("222");
			userRepository.save(user2);
			
			Note note2 = new Note();
			note2.setUser(user2);
			note2.setContent("note2");
			noteRepository.save(note2);
			
		};
	}
	
}
