/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Person2 Author:   shaogz Date:     2021/6/16 1:46 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson.pojo.p2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
public class Person2 {

    private String firstname;

    private String lastname;

    private Date birthDay;

}
