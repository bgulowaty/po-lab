package pwr.edu.app;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.json.JsonMapper;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.ReDocOptions;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import pwr.edu.http.NoteController;
import pwr.edu.notes.InMemoryNoteRepository;
import pwr.edu.notes.NoteRepository;
import pwr.edu.notes.NoteService;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

public class Application {

  private static final String FRONTEND_APP_CLASSPATH = "/frontend";
  private static final int SERVER_PORT = 7070;

  public static void main(String[] args) {
    JsonMapper gsonMapper = new GsonMapper();
    NoteController noteController = bootstrapController();

    Javalin app = Javalin.create(
        config -> {
          config.registerPlugin(getConfiguredOpenApiPlugin());
          config.defaultContentType = "application/json";
          config.enableCorsForAllOrigins();
          config.addStaticFiles(FRONTEND_APP_CLASSPATH, Location.CLASSPATH);
          config.jsonMapper(gsonMapper);
        }
    ).start(SERVER_PORT);

    app.routes(() ->
        path("api/notes", () -> {
          get(noteController::getAllNotes);
          post(noteController::addNote);
          delete("/{id}", noteController::deleteNote);
        }));
  }

  private static NoteController bootstrapController() {
    NoteRepository noteRepository = new InMemoryNoteRepository();
    NoteService noteService = new NoteService(noteRepository);
    return new NoteController(noteService);
  }

  private static OpenApiPlugin getConfiguredOpenApiPlugin() {
    Info info = new Info().version("1.0").description("User API");
    OpenApiOptions options = new OpenApiOptions(info)
        .activateAnnotationScanningFor("pwr.edu.http")
        .path("/swagger-docs") // endpoint for OpenAPI json
        .swagger(new SwaggerOptions("/swagger-ui")) // endpoint for swagger-ui
        .reDoc(new ReDocOptions("/redoc"));
    return new OpenApiPlugin(options);
  }
}
