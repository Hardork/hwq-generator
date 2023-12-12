package com.hwq.cli;

import com.hwq.cli.command.GenerateCommand;
import com.hwq.cli.example.Example;
import picocli.CommandLine;

@CommandLine.Command(name = "gen", mixinStandardHelpOptions = true, version = "Picocli example 4.0")
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        commandLine = new CommandLine(this).addSubcommand(new GenerateCommand());
    }

    /**
     * 实现集体的业务,按下回车后会执行
     */
    public void run() {
    }

    public static void main(String[] args) {
        // By implementing Runnable or Callable, parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.

        int exitCode = new CommandLine(new Example()).execute(args);
        System.exit(exitCode);
    }
}