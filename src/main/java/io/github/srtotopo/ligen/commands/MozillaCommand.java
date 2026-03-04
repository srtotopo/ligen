package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.services.FileService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "mozilla",
        version = "1.0.0",
        description = {
                "Generate Mozilla Public License 2.0",
                "A weak copyleft license that applies on a file-by-file basis. Modified files remain under MPL,",
                "but can be combined with proprietary code in larger projects, balancing openness with flexibility."
        },
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n"
)
public class MozillaCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("mozilla2");
            FileService.writeFile(license, output.path);

            System.out.println("\nMozilla Public License generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
