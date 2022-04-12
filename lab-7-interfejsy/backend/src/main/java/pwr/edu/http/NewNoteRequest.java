package pwr.edu.http;

import pwr.edu.notes.NewNote;

class NewNoteRequest {

  private final String title;
  private final String subtitle;
  private final String body;

  NewNoteRequest(String title, String subtitle, String body) {
    this.title = title;
    this.subtitle = subtitle;
    this.body = body;
  }

  NewNote asNote() {
    return new NewNote(title, subtitle, body);
  }
}
