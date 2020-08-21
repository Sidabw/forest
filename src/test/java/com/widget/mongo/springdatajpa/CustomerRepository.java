/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: CustomerRepository
 * Author:   feiyi
 * Date:     2020/8/21 2:27 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.mongo.springdatajpa;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/8/21
 * @since 1.0.0
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);

    public List<Customer> findByLastName(String lastName);

}
