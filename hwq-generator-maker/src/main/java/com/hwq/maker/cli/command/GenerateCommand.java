package com.hwq.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import com.hwq.maker.generator.file.DynamicFileGenerator;
import com.hwq.maker.model.MainTemplateConfig;
import lombok.Data;
import picocli.CommandLine;

import java.util.concurrent.Callable;

/**
 * @Author:HWQ
 * @DateTime:2023/12/12 15:27
 * @Description:
 **/
@CommandLine.Command(name = "generate", description = "生成文件", mixinStandardHelpOptions = true)
@Data
public class GenerateCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-l", "--loop"}, arity = "0..1", description = "是否循环", interactive = true, echo = true)
    private boolean loop;

    @CommandLine.Option(names = {"-a", "--author"}, arity = "0..1", description = "作者", interactive = true, echo = true)
    String author = "hwq";

    @CommandLine.Option(names = {"-o", "--outputText"}, arity = "0..1", description = "输出内容", interactive = true, echo = true)
    String outputText = "sum = ";

    public Integer call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        BeanUtil.copyProperties(this, mainTemplateConfig);
        System.out.println("配置信息" + mainTemplateConfig);
//        DynamicFileGenerator.Generate(mainTemplateConfig);
        return 0;
    }

}
