package pwr.edu.notes;

import java.util.List;

public class NoteService {

  private final InMemoryNoteRepository repository;

  public NoteService(InMemoryNoteRepository repository) {this.repository = repository;}

  public NoteId addNewNote(NewNote newNote) {
    // validate title

    return NoteId.of(repository.save(newNote));
  }

  public void deleteNote(NoteId noteId) {
    repository.delete(noteId.getId());
  }

  public List<SavedNote> getAllNotes() {
    return repository.getAll();
  }
}
