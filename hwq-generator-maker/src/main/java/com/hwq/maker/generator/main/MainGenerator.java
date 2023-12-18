package com.hwq.maker.generator.main;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.StrUtil;
import com.hwq.maker.generator.JarGenerator;
import com.hwq.maker.generator.ScriptGenerator;
import com.hwq.maker.generator.file.DynamicFileGenerator;
import com.hwq.maker.meta.Meta;
import com.hwq.maker.meta.MetaManager;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

/**
 * @Author:HWQ
 * @DateTime:2023/12/16 21:53
 * @Description:
 **/
public class MainGenerator extends GenerateTemplate{
    @Override
    protected void buildDist(String outputPath, String sourceCopyDestPath, String jarPath, String shellOutputFilePath) {
        System.out.println("不要给我输出 dist 啦");
    }
}
