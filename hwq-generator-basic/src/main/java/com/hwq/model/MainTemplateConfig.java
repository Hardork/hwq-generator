package com.hwq.model;

import lombok.Data;

/**
 * @Author:HWQ
 * @DateTime:2023/12/11 10:20
 * @Description:
 **/
@Data
public class MainTemplateConfig {
    /**
     * 是否循环
     */
    private boolean loop;

    /**
     * 作者
     */
    private String author;

    /**
     * 输出内容
     */
    private String outputText;
}
