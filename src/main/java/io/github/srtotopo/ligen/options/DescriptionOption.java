package io.github.srtotopo.ligen.options;

public class DescriptionOption {
        @picocli.CommandLine.Option(
                names = {"-d", "--description"},
                description = "Project description. (Default: generic description)",
                defaultValue = "A project licensed under the specified license."
        )
        public String text;
}
