package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.DescriptionOption;
import io.github.srtotopo.ligen.options.IdentifyOption;
import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.services.FileService;
import io.github.srtotopo.ligen.services.ParserService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "agpl",
        version = "1.0.0",
        description = {
                "Generate AGPL v3 license",
                "A network-oriented copyleft license that requires source code availability even for network",
                "interactions. Ideal for web applications and cloud services that interact with users over the internet."
        },
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n"
)
public class AGPLCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @CommandLine.Mixin
    private IdentifyOption identify;

    @CommandLine.Mixin
    private DescriptionOption description;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("agpl3");

            String parsedLicense = ParserService.parse(license)
                    .name(identify.name)
                    .year(identify.year)
                    .description(description.text)
                    .build();

            FileService.writeFile(parsedLicense, output.path);

            System.out.println("\nAGPL3 license generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
