package com.hwq;

import com.hwq.cli.CommandExecutor;

/**
 * @Author:HWQ
 * @DateTime:2023/12/15 18:09
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
//        String[] param = {"config"};
//        String[] param = {"list"};
        String[] param = {"generate", "-l", "-a", "-o"};
        CommandExecutor commandExecutor = new CommandExecutor();
        commandExecutor.doExecutor(param);
    }
}
