package com.hwq.maker.meta;

/**
 * @Author:HWQ
 * @DateTime:2023/12/18 0:25
 * @Description:
 **/
public class MetaException extends RuntimeException{
    public MetaException(String message) {
        super(message);
    }

    public MetaException(String message, Throwable cause) {
        super(message, cause);
    }
}
