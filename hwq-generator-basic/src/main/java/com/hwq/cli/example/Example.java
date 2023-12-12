package com.hwq.cli.example;

import picocli.CommandLine;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import java.io.File;

@CommandLine.Command(name = "ASCIIArt", mixinStandardHelpOptions = true, version = "Picocli example 4.0")
public class Example implements Runnable {

    @Option(names = { "-s", "--font-size" },
      description = "Font size")
    int fontSize = 19;

    @Parameters(paramLabel = "<word>", defaultValue = "Hello picocli", description = "Words to be translated into ASCII art")
    private String[] words = {"hello", "picocli"};

    /**
     * 实现集体的业务,按下回车后会执行
     */
    public void run() {
        System.out.println("fontSize = " + fontSize);
        System.out.println("words = " + String.join(",", words));
    }

    public static void main(String[] args) {
        // By implementing Runnable or Callable, parsing, error handling and handling user
        // requests for usage help or version help can be done with one line of code.

        int exitCode = new CommandLine(new Example()).execute(args);
        System.exit(exitCode);
    }
}