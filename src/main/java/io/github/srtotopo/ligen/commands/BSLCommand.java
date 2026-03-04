package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.services.FileService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "bsl",
        version = "1.0.0",
        description = {
                "Generate BSL 1.0 license",
                "A simple and permissive license commonly used for C++ libraries like Boost. Requires minimal",
                "attribution in documentation, making it very liberal for commercial and open-source use."
        },
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n"
)
public class BSLCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("bsl");
            FileService.writeFile(license, output.path);

            System.out.println("\nBSL license generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
