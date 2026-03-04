package io.github.srtotopo.ligen.options;

import picocli.CommandLine;

public class ProgramOption {
    @CommandLine.Option(
            names = {"-p", "--program"},
            description = "Program name. (Required)",
            required = true
    )
    public String name;
}
