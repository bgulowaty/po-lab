package pwr.edu.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import io.javalin.plugin.json.JsonMapper;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class GsonMapper implements JsonMapper {

  private static final Gson GSON = new GsonBuilder()
      .registerTypeAdapter(
          LocalDateTime.class,
          (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
              ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime())
      .create();

  @NotNull
  @Override
  public String toJsonString(@NotNull Object obj) {
    return GSON.toJson(obj);
  }

  @NotNull
  @Override
  public <T> T fromJsonString(@NotNull String json, @NotNull Class<T> targetClass) {
    return GSON.fromJson(json, targetClass);
  }
}
