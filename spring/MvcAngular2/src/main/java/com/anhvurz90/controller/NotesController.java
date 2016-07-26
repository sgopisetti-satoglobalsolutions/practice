package com.anhvurz90.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anhvurz90.database.NoteRepository;
import com.anhvurz90.database.UserRepository;
import com.anhvurz90.exception.UserNotFoundException;
import com.anhvurz90.model.Note;
import com.anhvurz90.model.User;

@RestController
@RequestMapping("{username}/notes")
public class NotesController {

	@Autowired
	NoteRepository noteRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@RequestMapping
	Collection<Note> readNotes(@PathVariable String username) {
		return noteRepository.findByUserUsername(username);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addNote(@PathVariable String username, @Valid @RequestBody Note note) {
		User user = userRepository.findByUsername(username)
				.orElseThrow(() -> new UserNotFoundException(username));
		note.setUser(user);
		noteRepository.save(note);
	}
}
