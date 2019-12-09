/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: Demo
 * Author:   feiyi
 * Date:     2019/6/24 3:29 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.bak.spirng;

import com.beta.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/24
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class Demo {


    @Test
    public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, FileNotFoundException, InstantiationException, ClassNotFoundException {


//        requestMappingHandlerMapping.registerMapping();
    }

//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("/Users/feiyi/Documents/feiyiGitProject/forest/src/main/resources/application.properties");
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("./application.properties");
//        EsServiceImpl bean = applicationContext.getBean(EsServiceImpl.class);
//        System.out.println(bean);
}
