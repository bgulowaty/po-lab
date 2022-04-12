package pwr.edu.http;

import java.util.List;

class AllNotesResponse {

  private final List<SavedNoteResponse> notes;

  AllNotesResponse(List<SavedNoteResponse> notes) {this.notes = notes;}
}
