package io.github.srtotopo.ligen.commands;

import io.github.srtotopo.ligen.options.OutputOption;
import io.github.srtotopo.ligen.services.FileService;
import picocli.CommandLine;

import java.io.IOException;
import java.nio.file.Paths;

@CommandLine.Command(
        name = "lgpl",
        description = "Generates a LGPL3 license file.",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true
)
public class LGPLCommand implements Runnable {
    @CommandLine.Mixin
    private OutputOption output;

    @Override
    public void run() {
        try {
            String license = FileService.loadTemplate("lgpl3");
            FileService.writeFile(license, output.path);

            System.out.println("\nLGPL3 license generated at:");
            System.out.println("\u001B[93m" + Paths.get(output.path).toAbsolutePath() + "\u001B[0m");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
