/**
 * Copyright (C), 2018-2021, bokecc.com FileName: Person3 Author:   shaogz Date:     2021/6/16 2:10 PM Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson.pojo.p3;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

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
public class Person3 {

    private String firstname;

    private String lastname;

    @JsonDeserialize(using = BooleanToIntDeserializer.class)
    @JsonSerialize(using = BooleanToIntSerializer.class)
    private Boolean isMale;

}
