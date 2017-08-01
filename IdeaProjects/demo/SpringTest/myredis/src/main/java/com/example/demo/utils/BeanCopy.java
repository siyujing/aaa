package com.example.demo.utils;


/**
 * Created by boxfish on 17/7/7.
 */
public interface BeanCopy {

    default Object copy() throws Exception {
        return FormatUtils.fromJson(FormatUtils.toJson(this), this.getClass());
    }

}
