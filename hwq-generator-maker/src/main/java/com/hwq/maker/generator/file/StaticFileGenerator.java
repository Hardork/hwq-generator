package com.hwq.maker.generator.file;

import cn.hutool.core.io.FileUtil;

/**
 * @Author:HWQ
 * @DateTime:2023/12/9 14:08
 * @Description: 拷贝文件类
 **/
public class StaticFileGenerator {
    /**
     * 拷贝文件
     * @param inputPath
     * @param outputPath
     */
    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
