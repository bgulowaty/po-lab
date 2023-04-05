package pl.pwr.persistence.localjson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.pwr.persistence.UserRepository;
import pl.pwr.user.User;

import java.io.*;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class LocalJsonFileRepositoryLoader {

    private static final Logger LOGGER = Logger.getLogger(LocalJsonFileRepositoryLoader.class.getName());
    static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final String repositoryFilePath;

    public LocalJsonFileRepositoryLoader(String repositoryFilePath) {
        this.repositoryFilePath = repositoryFilePath;
    }

    public UserRepository loadOrCreate() {
        try {
            Map<String, User> users =
                    GSON.fromJson(GSON.newJsonReader(new FileReader(repositoryFilePath)), Map.class);

            if (users != null) {
                LOGGER.info("Loaded users from path " + repositoryFilePath);
                LOGGER.info(users.toString());

                return new LocalJsonFileUserRepository(users);
            } else {
                return new LocalJsonFileUserRepository(Collections.emptyMap());
            }
        } catch (FileNotFoundException e) {
            LOGGER.info("Database file does not exist");

            return new LocalJsonFileUserRepository(Collections.emptyMap());
        }
    }

    public void save(UserRepository repository) throws IOException {
        if (!(repository instanceof LocalJsonFileUserRepository)) {
            throw new IllegalAccessError("Repository needs to be LocalJsonFileUserRepository");
        }

        LOGGER.info("Saving database to file=" + repositoryFilePath);

        try(Writer writer = new FileWriter(repositoryFilePath)) {
            writer.write(GSON.toJson(((LocalJsonFileUserRepository) repository).getDatabase()));
        }
    }
}
