/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Person Author:   shaogz Date:     2021/6/16 12:01 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson.pojo.p1;

import lombok.Data;

import java.util.List;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
@Data
public class Person {

    private String firstname;

    private String lastname;

    private Address address;

    private List<PhoneNumber> phones;

}
