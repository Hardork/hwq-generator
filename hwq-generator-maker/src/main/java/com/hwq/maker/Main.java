package com.hwq.maker;

import com.hwq.maker.cli.CommandExecutor;
import com.hwq.maker.meta.Meta;
import com.hwq.maker.meta.MetaManager;

/**
 * @Author:HWQ
 * @DateTime:2023/12/15 18:09
 * @Description:
 **/
public class Main {
    public static void main(String[] args) {
//        String[] param = {"config"};
//        String[] param = {"list"};
//        String[] param = {"generate", "-l", "-a", "-o"};
//        CommandExecutor commandExecutor = new CommandExecutor();
//        commandExecutor.doExecutor(param);
        Meta meta = MetaManager.getMetaObject();
        System.out.println(meta);
    }
}
