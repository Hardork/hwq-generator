package com.hwq.maker.meta.enums;

/**
 * @Author:HWQ
 * @DateTime:2023/12/18 21:33
 * @Description:
 **/
public enum FileGenerateTypeEnum {
    DYNAMIC("动态", "dynamic"),
    STATIC("静态", "static");

    private final String text;

    private final String value;

    FileGenerateTypeEnum(String text, String value) {
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
