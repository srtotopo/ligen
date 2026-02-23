package io.github.srtotopo.ligen;

import picocli.CommandLine;

import java.nio.file.Paths;

@CommandLine.Command(
        name = "ligen",
        version = "1.0.0",
        description = "A command-line tool for generating licenses files for open-source projects.",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true
)
public class Ligen implements Runnable {
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "The output file path for the generated license file.",
            defaultValue = "${sys:user.dir}"
    )
    private String output;

    @Override
    public void run() {
        System.out.println("Path to output file: " + Paths.get(output).toAbsolutePath());
    }
}
