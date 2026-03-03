package io.github.srtotopo.ligen.services;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private FileService() {
        throw new UnsupportedOperationException("FileService is a utility class and cannot be instantiated.");
    }

    public static String loadTemplate(String templateName) throws IOException {
        String resourcePath = "/templates/" + templateName.toLowerCase() + ".txt";

        try (InputStream inputStream = FileService.class.getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                throw new IOException("Template not found: " + templateName);
            }

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new IOException("Failed to load template: " + templateName, e);
        }
    }

    public static void writeFile(String content, String outputPath) throws IOException {
        try {
            Path dirpath = Paths.get(outputPath);

            if (!Files.exists(dirpath)) {
                Files.createDirectories(dirpath);
            }

            Path filePath = dirpath.resolve("LICENSE");
            Files.writeString(filePath, content);
        } catch (IOException e) {
            throw new IOException("Failed to write file to: " + outputPath, e);
        }
    }
}
