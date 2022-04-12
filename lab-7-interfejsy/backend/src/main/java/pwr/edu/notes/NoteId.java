package pwr.edu.notes;

import java.util.UUID;


public class NoteId {

  private final UUID id;

  public NoteId(UUID id) {this.id = id;}

  public static NoteId of(UUID uuid) {
    return new NoteId(uuid);
  }

  @Override
  public int hashCode() {
    return id != null ? id.hashCode() : 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;

    NoteId noteId = (NoteId) o;

    return id != null ? id.equals(noteId.id) : noteId.id == null;
  }

  @Override
  public String toString() {
    return "NoteId{" +
        "id=" + id +
        '}';
  }

  public UUID getId() {
    return id;
  }
}
