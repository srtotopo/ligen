package io.github.srtotopo.ligen;

import io.github.srtotopo.ligen.commands.MitCommand;
import picocli.CommandLine;

@CommandLine.Command(
        name = "ligen",
        version = "1.0.0",
        description = "A command-line tool for generating licenses files for open-source projects.",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true,
        subcommands = { MitCommand.class }
)
public class Ligen implements Runnable {
    @Override
    public void run() {
        CommandLine cmd = new CommandLine(this);
        cmd.usage(System.out);
    }
}
