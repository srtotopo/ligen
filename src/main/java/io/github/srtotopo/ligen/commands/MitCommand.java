package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.IdentifyOption;
import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.services.FileService;
import io.github.srtotopo.ligen.services.ParserService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "mit",
        version = "1.0.0",
        description = {
                "Generate MIT license",
                "A simple and permissive open-source license that allows users to use, modify, and distribute",
                "the software with minimal restrictions. Perfect for projects that want maximum freedom of use."
        },
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n"
)
public class MitCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @CommandLine.Mixin
    private IdentifyOption identify;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("mit");

            String parsedLicense = ParserService.parse(license)
                    .name(identify.name)
                    .year(identify.year)
                    .build();

            FileService.writeFile(parsedLicense, output.path);

            System.out.println("\nMIT license generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
