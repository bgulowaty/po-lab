package pwr.edu.notes;

import com.google.common.collect.Lists;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryNoteRepository {

  private final Map<UUID, SavedNote> repo = new ConcurrentHashMap<>();

  public UUID save(NewNote note) {
    UUID noteId = UUID.randomUUID();

    SavedNote savedNote = new SavedNote(
        NoteId.of(noteId),
        note.getTitle(),
        note.getSubtitle(),
        LocalDateTime.now(),
        note.getBody()
    );

    repo.put(noteId, savedNote);

    return noteId;
  }

  public void delete(UUID uuid) {
    repo.remove(uuid);
  }

  public List<SavedNote> getAll() {
    return Lists.newArrayList(repo.values());
  }
}
