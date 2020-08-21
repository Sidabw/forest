/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2020/5/9 4:58 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.basic.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/5/9
 * @since 1.0.0
 */
public class Demo {

    private static final Logger LOGGER = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        try {
            new Demo().t1();
        } catch (Exception e) {
            //正常的异常堆栈信息不会有caused by，只有该异常调用了Throwable的initCause(e)方法之后，该异常的堆栈信息里才会有caused by
            LOGGER.error("", e);
        }
    }

    private void t1() {
        try {
            t2();
        } catch (Exception e) {
            LOGGER.error("", e);
            MyException myException = new MyException(e.getMessage());
            myException.initCause(e);
            throw myException;
        }
    }

    private void t2() {
        t3();
    }

    private void t3() {
        t4();
    }

    private void t4() {
        throw new MyException("aaa");
    }
}


class MyException extends RuntimeException {

    public MyException(String msg) {
        super(msg);
    }

}
