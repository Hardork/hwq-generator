package com.hwq.cli.command;

import cn.hutool.core.util.ReflectUtil;
import com.hwq.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.lang.reflect.Field;

/**
 * @Author:HWQ
 * @DateTime:2023/12/15 15:58
 * @Description:
 **/
@Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{
    @Override
    public void run() {
        System.out.println("查看参数信息");

        // 获取模板信息
        Field[] fields = ReflectUtil.getFields(MainTemplateConfig.class);
        for (Field field : fields) {
            System.out.println("字段名称" + field.getName());
            System.out.println("字段类型" + field.getType());
            System.out.println("------");
        }
    }
}
