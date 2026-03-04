package io.github.srtotopo.ligen.options;

import picocli.CommandLine;

public class OutputOption {
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "Output file path. (Default: current directory)",
            defaultValue = "${sys:user.dir}"
    )
    public String path;
}
