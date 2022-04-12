package pwr.edu.notes;

import java.time.LocalDateTime;

public class SavedNote {

  private final NoteId noteId;
  private final String title;
  private final String subtitle;
  private final LocalDateTime createdAt;
  private final String body;

  public SavedNote(
      NoteId noteId, String title, String subtitle, LocalDateTime createdAt, String body) {
    this.noteId = noteId;
    this.title = title;
    this.subtitle = subtitle;
    this.createdAt = createdAt;
    this.body = body;
  }

  public NoteId getNoteId() {
    return noteId;
  }

  public String getTitle() {
    return title;
  }

  public String getSubtitle() {
    return subtitle;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public String getBody() {
    return body;
  }
}
