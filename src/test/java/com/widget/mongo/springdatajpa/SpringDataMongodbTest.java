/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: SpringDataMongodbTest
 * Author:   feiyi
 * Date:     2020/8/21 2:30 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mongo.springdatajpa;

import com.beta.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/8/21
 * @since 1.0.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
@EnableMongoRepositories
public class SpringDataMongodbTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    public void test() {
        System.out.println(repository);
    }

}
