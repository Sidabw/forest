/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: ModelNode2
 * Author:   feiyi
 * Date:     2019/7/4 10:33 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.test;

import org.apache.poi.ss.formula.functions.T;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/7/4
 * @since 1.0.0
 */
public class ModelNode2<T, E> {
    private String curModelId;

    private T previousModelId;

    private E forwardModelId;

    public ModelNode2(String curModelId, T previousModelId, E forwardModelId) {
        this.curModelId = curModelId;
        this.previousModelId = previousModelId;
        this.forwardModelId = forwardModelId;
    }

    public String getCurModelId() {
        return curModelId;
    }

    public void setCurModelId(String curModelId) {
        this.curModelId = curModelId;
    }

    public T getPreviousModelId() {
        return previousModelId;
    }

    public void setPreviousModelId(T previousModelId) {
        this.previousModelId = previousModelId;
    }

    public E getForwardModelId() {
        return forwardModelId;
    }

    public void setForwardModelId(E forwardModelId) {
        this.forwardModelId = forwardModelId;
    }
}
