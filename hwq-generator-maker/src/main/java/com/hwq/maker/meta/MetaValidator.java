package com.hwq.maker.meta;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.io.FileUtil;
import com.hwq.maker.meta.Meta.FileConfig.Files;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.hwq.maker.meta.Meta.FileConfig;
import com.hwq.maker.meta.Meta.ModelConfig;
import com.hwq.maker.meta.enums.FileGenerateTypeEnum;
import com.hwq.maker.meta.enums.FileTypeEnum;

/**
 * @Author:HWQ
 * @DateTime:2023/12/18 0:27
 * @Description:
 **/
public class MetaValidator {
    public static void doValidAndFill(Meta meta) {
        // 基本信息校验
        basicValid(meta);
        // 文件配置校验
        validAndFillFileConfig(meta);
        // modelConfig 校验和默认值
        validAndFillModelConfig(meta);
    }

    private static void validAndFillModelConfig(Meta meta) {
        ModelConfig modelConfig = meta.getModelConfig();
        if (modelConfig != null) {
            List<ModelConfig.Models> modelList = modelConfig.getModels();
            if (CollectionUtil.isNotEmpty(modelList)) {
                for (ModelConfig.Models models : modelList) {
                    // 输出默认路径
                    String fieldName = models.getFieldName();
                    if (StrUtil.isBlank(fieldName)) {
                        throw new MetaException("未填写 fieldName");
                    }
                    String type = models.getType();
                    if (StrUtil.isEmpty(type)) {
                        models.setType("String");
                    }
                }
            }
        }
    }

    private static void validAndFillFileConfig(Meta meta) {
        FileConfig fileConfig = meta.getFileConfig();
        if (fileConfig == null) {
            return;
        }
        // sourceRootPath必填
        String sourceRootPath = fileConfig.getSourceRootPath();
        if (StrUtil.isBlank(sourceRootPath)) {
            throw new MetaException("未填写 sourceRootPath");
        }
        // inputRootPath：.source + sourceRootPath的最后一个层级
        String inputRootPath = fileConfig.getInputRootPath();
        String defaultInputRootPath = ".source" + File.separator + FileUtil.getLastPathEle(Paths.get(sourceRootPath)).getFileName().toString();
        if (StrUtil.isBlank(inputRootPath)) {
            fileConfig.setInputRootPath(defaultInputRootPath);
        }
        // outputRootPath：默认放在generated目录下
        String outputRootPath = fileConfig.getOutputRootPath();
        String defaultOutputRootPath = "generated";
        if (StrUtil.isBlank(outputRootPath)) {
            fileConfig.setOutputRootPath(defaultOutputRootPath);
        }
        // 默认文件为dir
        String type = fileConfig.getType();
        String defaultType = FileTypeEnum.DIR.getValue();
        if (StrUtil.isBlank(type)) {
            fileConfig.setType(defaultType);
        }
        List<Files> files = fileConfig.getFiles();
        // fileInfo 默认值
        if (CollectionUtil.isEmpty(files)) {
            return;
        }
        for (Files file : files) {
            // inputPath：必填
            String inputPath = file.getInputPath();
            if (StrUtil.isBlank(inputPath)) {
                throw new MetaException("未填写 inputPath");
            }
            // outputPath：默认等于inputPath
            String outputPath = file.getOutputPath();
            if (StrUtil.isBlank(outputPath)) {
                file.setOutputPath(inputPath);
            }
            // fileType：文件类型
            String fileType = file.getType();
            if (StrUtil.isBlank(fileType)) {
                // 判断是否有文件后缀
                if (StrUtil.isBlank(FileUtil.getSuffix(inputPath))) {
                    file.setType(FileTypeEnum.DIR.getValue());
                } else {
                    file.setType(FileTypeEnum.FILE.getValue());
                }
            }
            // 生成类型，默认为static
            String generateType = file.getGenerateType();
            if (StrUtil.isBlank(generateType)) {
                // 为动态模板
                if (inputPath.endsWith(".ftl")) {
                    file.setGenerateType(FileGenerateTypeEnum.DYNAMIC.getValue());
                } else {
                    file.setGenerateType(FileGenerateTypeEnum.STATIC.getValue());
                }
            }
        }
    }

    private static void basicValid(Meta meta) {
        // 校验并填充默认值
        String name = StrUtil.blankToDefault(meta.getName(), "my-generator");
        String description = StrUtil.emptyToDefault(meta.getDescription(), "我的模板代码生成器");
        String author = StrUtil.emptyToDefault(meta.getAuthor(), "hwq");
        String basePackage = StrUtil.blankToDefault(meta.getBasePackage(), "com.hwq");
        String version = StrUtil.emptyToDefault(meta.getVersion(), "1.0");
        String createTime = StrUtil.emptyToDefault(meta.getCreateTime(), DateUtil.now());
        meta.setName(name);
        meta.setDescription(description);
        meta.setAuthor(author);
        meta.setBasePackage(basePackage);
        meta.setVersion(version);
        meta.setCreateTime(createTime);
    }
}
