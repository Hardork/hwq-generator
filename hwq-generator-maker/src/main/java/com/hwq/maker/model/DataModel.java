package com.hwq.maker.model;

import lombok.Data;

/**
 * @Author:HWQ
 * @DateTime:2023/12/16 20:45
 * @Description:
 **/
@Data
public class DataModel {
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
