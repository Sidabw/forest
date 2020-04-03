/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: StudentSida
 * Author:   feiyi
 * Date:     2019/4/30 2:25 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.designMode.callback.callbackdemo.student;

import com.Java.designMode.callback.callbackdemo.teacher.ITeacherCallback;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/30
 * @since 1.0.0
 */
public class StudentSida implements IStudent {

    @Override
    public void resolveQuestions(ITeacherCallback callback) {
        System.out.println(this.getClass().getName() + "    问题解决了");
        callback.tellAnswer(1);
    }
}
