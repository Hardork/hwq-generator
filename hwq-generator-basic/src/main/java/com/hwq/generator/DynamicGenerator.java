package com.hwq.generator;

import com.hwq.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @Author:HWQ
 * @DateTime:2023/12/11 10:25
 * @Description: 动态生成
 **/
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {
        // 设置
        String inputPath = new File("hwq-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl").getPath();
        String outputPath = new File("hwq-generator-basic" + File.separator + "MainTemplate.java").getPath();
//
        // 生成模型
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig();
        mainTemplateConfig.setLoop(true);
        mainTemplateConfig.setAuthor("hwq");
        mainTemplateConfig.setOutputText("输出结果");
        doGenerate(inputPath, outputPath, mainTemplateConfig);
    }

    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // 设置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        File inputFile = new File(inputPath);
        configuration.setDirectoryForTemplateLoading(inputFile.getParentFile());
        configuration.setDefaultEncoding("utf-8");
        // 读取模板
        Template template = configuration.getTemplate(inputFile.getName());

        // 生成文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 关闭文件流
        out.close();
    }

    public static void Generate(Object model) throws IOException, TemplateException {
        // 设置
        String inputPath = new File("hwq-generator-basic" + File.separator + "src/main/resources/templates/MainTemplate.java.ftl").getPath();
        String outputPath = new File("hwq-generator-basic" + File.separator + "MainTemplate.java").getPath();
        // 设置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);
        File inputFile = new File(inputPath);
        configuration.setDirectoryForTemplateLoading(inputFile.getParentFile());
        configuration.setDefaultEncoding("utf-8");
        // 读取模板
        Template template = configuration.getTemplate(inputFile.getName());

        // 生成文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 关闭文件流
        out.close();
    }
}
