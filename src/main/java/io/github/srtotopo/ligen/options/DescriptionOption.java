package io.github.srtotopo.ligen.options;

public class DescriptionOption {
        @picocli.CommandLine.Option(
                names = {"-d", "--description"},
                description = "A brief description of the project to be included in the license file.",
                defaultValue = "A project licensed under the specified license."
        )
        public String description;
}
