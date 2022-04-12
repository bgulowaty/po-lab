package pwr.edu.app;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.plugin.json.JsonMapper;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;
import pwr.edu.http.NoteController;
import pwr.edu.notes.InMemoryNoteRepository;
import pwr.edu.notes.NoteService;
import pwr.edu.serialization.GsonMapper;

import static io.javalin.apibuilder.ApiBuilder.delete;
import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;

class ApplicationConfigurer {

  private final ApplicaitonProperties properties;

  ApplicationConfigurer(ApplicaitonProperties properties) {this.properties = properties;}

  void configure() {
    JsonMapper gsonMapper = new GsonMapper();

    Javalin app = Javalin.create(
        config -> {
          config.registerPlugin(getConfiguredOpenApiPlugin());
          config.defaultContentType = "application/json";
          config.enableCorsForAllOrigins();
          config.addStaticFiles(properties.getFrontendAppClasspath(), Location.CLASSPATH);
          config.jsonMapper(gsonMapper);
        }
    );

    NoteController noteController = bootstrapController();
    app.routes(() ->
        path("api/notes", () -> {
          get(noteController::getAllNotes);
          post(noteController::addNote);
          delete("/{id}", noteController::deleteNote);
        }));

    app.start(properties.getPort());
  }

  private static NoteController bootstrapController() {
    NoteService noteService = new NoteService(new InMemoryNoteRepository());
    return new NoteController(noteService);
  }

  private static OpenApiPlugin getConfiguredOpenApiPlugin() {
    Info info = new Info().version("1.0").description("User API");
    OpenApiOptions options = new OpenApiOptions(info)
        .activateAnnotationScanningFor("pwr.edu.http")
        .path("/swagger-docs") // endpoint for OpenAPI json
        .swagger(new SwaggerOptions("/swagger-ui"));
    return new OpenApiPlugin(options);
  }
}
