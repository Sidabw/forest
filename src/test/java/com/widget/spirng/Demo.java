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
package com.widget.spirng;

import com.beta.Application;
import com.beta.widgets.elasticsearch.EsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
