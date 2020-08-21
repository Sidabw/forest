/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/4/30 2:28 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.Java.designMode.callback.callbackdemo.domain;

import com.Java.designMode.callback.callbackdemo.student.StudentSida;
import com.Java.designMode.callback.callbackdemo.teacher.TeacherBrew;
import org.junit.Test;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/4/30
 * @since 1.0.0
 */
public class Demo {

    @Test
    public void test() {
        TeacherBrew teacherBrew = new TeacherBrew(new StudentSida());
        teacherBrew.question();
    }
}
