package com.hwq.maker.cli;

import com.hwq.maker.cli.command.ConfigCommand;
import com.hwq.maker.cli.command.GenerateCommand;
import com.hwq.maker.cli.command.ListCommand;
import picocli.CommandLine;

@CommandLine.Command(name = "gen", mixinStandardHelpOptions = true, version = "Picocli example 4.0")
public class CommandExecutor implements Runnable {

    private final CommandLine commandLine;

    {
        // 添加命令
        commandLine = new CommandLine(this)
                .addSubcommand(new GenerateCommand())
                .addSubcommand(new ListCommand())
                .addSubcommand(new ConfigCommand())
        ;
    }

    /**
     * 实现集体的业务,按下回车后会执行
     */
    public void run() {
        System.out.println("请输入具体命令，或输入 --help 查看命令提示");
    }

    public Integer doExecutor(String[] args) {
        return commandLine.execute(args);
    }

}