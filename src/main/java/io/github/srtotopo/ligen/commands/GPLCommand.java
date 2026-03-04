package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.DescriptionOption;
import io.github.srtotopo.ligen.options.IdentifyOption;
import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.options.ProgramOption;
import io.github.srtotopo.ligen.services.FileService;
import io.github.srtotopo.ligen.services.ParserService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "gpl",
        version = "1.0.0",
        description = {
                "Generate GPL v3 license",
                "A strong copyleft license that ensures software remains free and open-source. Any derivatives",
                "or modifications must also be released under GPL, protecting the freedom of all users."
        },
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n%n",
        optionListHeading = "%nOptions:%n"
)
public class GPLCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @CommandLine.Mixin
    private IdentifyOption identify;

    @CommandLine.Mixin
    private DescriptionOption description;

    @CommandLine.Mixin
    private ProgramOption program;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("gpl3");

            String parsedLicense = ParserService.parse(license)
                    .name(identify.name)
                    .year(identify.year)
                    .description(description.text)
                    .program(program.name)
                    .build();

            FileService.writeFile(parsedLicense, output.path);

            System.out.println("\nGPL3 license generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
