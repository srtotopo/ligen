package io.github.srtotopo.ligen;

public class Main {
    public static void main(String[] args) {
        int exitCode = new picocli.CommandLine(new Ligen()).execute(args);
        System.exit(exitCode);
    }
}
