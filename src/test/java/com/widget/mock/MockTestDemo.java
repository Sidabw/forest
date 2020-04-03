/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: MockTestDemo
 * Author:   feiyi
 * Date:     2020/2/11 8:07 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package mock;

import com.beta.Application;
import com.beta.basic.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 〈一句话功能简述〉:
 * 〈https://mp.weixin.qq.com/s/ptInr3S7SRCj2lcGCI5QYA〉
 *
 * @author feiyi
 * @create 2020/2/11
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class MockTestDemo {

    @Autowired
    private UserService userService;

    @Test
    public void getUserById(){
        userService.queryList();
    }

}
