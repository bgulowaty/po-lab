package pwr.edu.http;

import java.time.LocalDateTime;

class SavedNoteResponse {

  private final String id;
  private final String title;
  private final String subtitle;
  private final LocalDateTime createdAt;
  private final String body;

  SavedNoteResponse(
      String id, String title, String subtitle, LocalDateTime createdAt, String body) {
    this.id = id;
    this.title = title;
    this.subtitle = subtitle;
    this.createdAt = createdAt;
    this.body = body;
  }
}
