package io.github.srtotopo.ligen.options;

import picocli.CommandLine;

public class OutputOption {
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "The output file path for the generated license file.",
            defaultValue = "${sys:user.dir}"
    )
    public String path;
}
