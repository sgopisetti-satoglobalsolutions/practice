package com.anhvurz90.database;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import com.anhvurz90.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

	Collection<Note> findByUserUsername(String username);
}
