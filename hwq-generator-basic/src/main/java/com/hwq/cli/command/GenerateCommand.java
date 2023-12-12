package com.hwq.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.hwq.generator.DynamicGenerator;
import com.hwq.model.MainTemplateConfig;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @Author:HWQ
 * @DateTime:2023/12/12 15:27
 * @Description:
 **/
public class GenerateCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环")
    private boolean loop;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者")
    String author = "hwq";

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出内容")
    String outputText = "sum = ";

    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息" + mainTemplateConfig);
        DynamicGenerator.Generate(mainTemplateConfig);
        return 0;
    }

}
