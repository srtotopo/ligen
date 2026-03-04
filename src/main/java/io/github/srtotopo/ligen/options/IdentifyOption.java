package io.github.srtotopo.ligen.options;

import picocli.CommandLine;
import java.time.Year;

public class IdentifyOption {
    @CommandLine.Option(
            names = {"-n", "--name"},
            description = "Author or organization name. (Required)",
            required = true
    )
    public String name;

    @CommandLine.Option(
            names = {"-y", "--year"},
            description = "Year for copyright notice. (Default: current year)"
    )
    public String year = String.valueOf(Year.now().getValue());
}
