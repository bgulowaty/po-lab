package pwr.edu.http;

import pwr.edu.notes.NoteId;

import java.util.UUID;

class NewNoteAddedResponse {

  private final UUID id;

  NewNoteAddedResponse(NoteId id) {this.id = id.getId();}

  UUID getId() {
    return id;
  }
}
