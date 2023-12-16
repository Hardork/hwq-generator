package com.hwq.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * @Author:HWQ
 * @DateTime:2023/12/16 21:29
 * @Description: 单例生成Meta
 **/
public class MetaManager {
    private static volatile Meta meta;

    private MetaManager() {

    }

    // 双重检验
    public static Meta getMetaObject() {
        if (meta == null) {
            // 锁class, 同一时刻多个线程只能有一个
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }

    private static Meta initMeta() {
        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        return JSONUtil.toBean(metaJson, Meta.class);
    }
}
