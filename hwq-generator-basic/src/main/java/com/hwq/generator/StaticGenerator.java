package com.hwq.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * @Author:HWQ
 * @DateTime:2023/12/9 14:08
 * @Description:
 **/
public class StaticGenerator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile(); // 存放目录
        String inputPath = new File(projectPath, "hwq-generator-demo-projects/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFilesByHuTool(inputPath, outputPath);
        System.out.println(projectPath);
    }

    /**
     * 拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHuTool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
