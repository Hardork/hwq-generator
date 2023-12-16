package com.hwq.maker.cli.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;

import java.io.File;
import java.util.List;

/**
 * @Author:HWQ
 * @DateTime:2023/12/15 15:58
 * @Description:
 **/
@Command(name = "list", description = "查看文件列表", mixinStandardHelpOptions = true)
public class ListCommand implements Runnable{
    @Override
    public void run() {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径
        String filePath = new File(parentFile, "hwq-generator.bat-demo-projects/acm-template").getAbsolutePath();
        List<File> files = FileUtil.loopFiles(filePath);
        for (File file : files) {
            System.out.println(file);
        }
    }
}
