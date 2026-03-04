package io.github.srtotopo.ligen;

import io.github.srtotopo.ligen.commands.*;
import picocli.CommandLine;

@CommandLine.Command(
        name = "ligen",
        version = "1.0.0",
        headerHeading = "%n██╗     ██╗ ██████╗ ███████╗███╗   ██╗%n" +
                        "██║     ██║██╔════╝ ██╔════╝████╗  ██║%n" +
                        "██║     ██║██║  ███╗█████╗  ██╔██╗ ██║%n" +
                        "██║     ██║██║   ██║██╔══╝  ██║╚██╗██║%n" +
                        "███████╗██║╚██████╔╝███████╗██║ ╚████║%n" +
                        "╚══════╝╚═╝ ╚═════╝ ╚══════╝╚═╝  ╚═══╝%n",
        description = "A command-line tool for generating licenses files for open-source projects.",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        synopsisHeading = "%nUsage:%n",
        descriptionHeading = "%nDescription:%n",
        commandListHeading = "%nAvailable Licenses:%n",
        optionListHeading = "%nOptions:%n",
        subcommands = {
                AGPLCommand.class,
                ApacheCommand.class,
                BSLCommand.class,
                GPLCommand.class,
                LGPLCommand.class,
                MitCommand.class,
                MozillaCommand.class,
                UnlicenseCommand.class
        }
)
public class Ligen implements Runnable {
    @Override
    public void run() {
        CommandLine cmd = new CommandLine(this);
        cmd.usage(System.out);
    }
}
