package com.hwq.cli.example;

import picocli.CommandLine;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.concurrent.Callable;

class Login implements Callable<Integer> {
    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, description = "Passphrase", interactive = true)
    String password;

    @CommandLine.Option(names = {"-cp", "--checkPassword"}, description = "checkPassword", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.print("password = " + password);
        System.out.print("checkPassword = " + checkPassword);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p", "-cp");
    }

}