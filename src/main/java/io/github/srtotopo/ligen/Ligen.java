package io.github.srtotopo.ligen;

import picocli.CommandLine;

@CommandLine.Command(
        name = "ligen",
        version = "1.0.0",
        description = "\nA command-line tool for generating licenses files for open-source projects.\n",
        mixinStandardHelpOptions = true,
        usageHelpAutoWidth = true
)
public class Ligen implements Runnable {
    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "The output file path for the generated license file.",
            defaultValue = "${sys:user.dir}",
            scope = CommandLine.ScopeType.INHERIT,
            hidden = true
    )
    private String output;

    @Override
    public void run() {
        CommandLine cmd = new CommandLine(this);
        cmd.usage(System.out);
    }
}
