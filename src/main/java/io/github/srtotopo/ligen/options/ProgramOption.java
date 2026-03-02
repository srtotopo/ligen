package io.github.srtotopo.ligen.options;

import picocli.CommandLine;

public class ProgramOption {
    @CommandLine.Option(
            names = {"-p", "--program"},
            description = "The name of the program for which the license file is being generated.",
            required = true
    )
    public String programName;
}
