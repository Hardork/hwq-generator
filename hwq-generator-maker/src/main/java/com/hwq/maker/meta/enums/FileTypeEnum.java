package com.hwq.maker.meta.enums;

/**
 * @Author:HWQ
 * @DateTime:2023/12/18 21:31
 * @Description:
 **/
public enum FileTypeEnum {
    DIR("目录", "dir"),
    FILE("文件", "file");

    private final String text;

    private final String value;

    FileTypeEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public String getValue() {
        return value;
    }
}
