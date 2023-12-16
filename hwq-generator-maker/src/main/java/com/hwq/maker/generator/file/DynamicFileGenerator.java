package com.hwq.maker.generator.file;

import cn.hutool.core.io.FileUtil;
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
public class DynamicFileGenerator {


    /**
     * 生成文件
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     * @throws IOException
     * @throws TemplateException
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        // 设置
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_32);

        // 指定模板文件路径
        File inputFile = new File(inputPath);
        configuration.setDirectoryForTemplateLoading(inputFile.getParentFile());

        // 指定字符集
        configuration.setDefaultEncoding("utf-8");

        // 读取模板
        Template template = configuration.getTemplate(inputFile.getName());

        // 文件不存在就创建文件和父目录
        if (!FileUtil.exist(outputPath)) {
            FileUtil.touch(outputPath);
        }

        // 生成文件
        Writer out = new FileWriter(outputPath);
        template.process(model, out);
        // 关闭文件流
        out.close();
    }
}
