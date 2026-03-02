package io.github.srtotopo.ligen.options;

import picocli.CommandLine;
import java.time.Year;

public class IdentifyOption {
    @CommandLine.Option(
            names = {"-n", "--name"},
            description = "The name of the author or organization to be included in the license file.",
            required = true
    )
    public String name;

    @CommandLine.Option(
            names = {"-y", "--year"},
            description = "The year to be included in the license file. Defaults to the current year."
    )
    public String year = String.valueOf(Year.now().getValue());
}
