package io.github.srtotopo.ligen.services;

import java.util.HashMap;
import java.util.Map;

public class ParserService {
    private final String content;
    private final Map<String, String> replacements;

    public ParserService(String content) {
        this.content = content;
        this.replacements = new HashMap<>();
    }

    public static ParserService parse(String content) {
        return new ParserService(content);
    }

    public ParserService name(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be empty or null.");
        }

        replacements.put("name", name);
        return this;
    }

    public ParserService year(String year) {
        if (year.isBlank()) {
            throw new IllegalArgumentException("Year cannot be empty or null.");
        }

        replacements.put("year", year);
        return this;
    }

    public ParserService description(String description) {
        if (description.isBlank()) {
            throw new IllegalArgumentException("Description cannot be empty or null.");
        }

        replacements.put("description", description);
        return this;
    }

    public ParserService program(String program) {
        if (program.isBlank()) {
            throw new IllegalArgumentException("Program name cannot be empty or null.");
        }

        replacements.put("program", program);
        return this;
    }

    public String build() {
        String result = content;

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            String placeholder = "{{" + entry.getKey() + "}}";
            result = result.replace(placeholder, entry.getValue());
        }

        return result;
    }
}
