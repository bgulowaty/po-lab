package pwr.edu.http;

import io.javalin.http.Context;
import io.javalin.plugin.openapi.annotations.*;
import pwr.edu.notes.NoteId;
import pwr.edu.notes.NoteService;
import pwr.edu.notes.SavedNote;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class NoteController {

  private final NoteService noteService;

  public NoteController(NoteService noteService) {this.noteService = noteService;}

  @OpenApi(
      path = "/api/notes",
      method = HttpMethod.GET,
      summary = "Get all notes",
      operationId = "getAllNotes",
      responses = {
          @OpenApiResponse(status = "200", content = { @OpenApiContent(from = SavedNote[].class) })
      })
  public void getAllNotes(Context context) {
    List<SavedNote> allNotes = noteService.getAllNotes();

    List<SavedNoteResponse> savedNoteResponses = allNotes.stream()
        .map(note -> new SavedNoteResponse(
            note.getNoteId().getId().toString(),
            note.getTitle(),
            note.getSubtitle(),
            note.getCreatedAt(),
            note.getBody()
        )).collect(toList());

    context.json(new AllNotesResponse(savedNoteResponses));
  }

  @OpenApi(
      path = "/api/notes",
      method = HttpMethod.POST,
      summary = "Add note",
      operationId = "addNote",
      requestBody = @OpenApiRequestBody(
          required = true,
          content = { @OpenApiContent(from = NewNoteRequest.class) }),
      responses = {
          @OpenApiResponse(status = "200", content = {
              @OpenApiContent(from = NewNoteAddedResponse.class) })
      })
  public void addNote(Context context) {
    NewNoteRequest newNoteRequest = context.bodyAsClass(NewNoteRequest.class);

    NoteId noteId = noteService.addNewNote(newNoteRequest.asNote());

    context.json(new NewNoteAddedResponse(noteId));
  }


  @OpenApi(
      path = "/api/notes",
      method = HttpMethod.DELETE,
      summary = "Delete note",
      operationId = "deleteNote",
      pathParams = { @OpenApiParam(name = "id", required = true) },
      responses = {
          @OpenApiResponse(status = "200")
      })
  public void deleteNote(Context context) {
    String id = context.pathParam("id");
    noteService.deleteNote(NoteId.of(UUID.fromString(id)));
  }
}
