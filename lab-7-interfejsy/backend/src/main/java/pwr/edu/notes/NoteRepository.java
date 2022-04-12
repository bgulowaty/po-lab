package pwr.edu.notes;

import java.util.List;
import java.util.UUID;

public interface NoteRepository {

  UUID save(NewNote note);

  void delete(UUID uuid);

  List<SavedNote> getAll();
}
