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

    public String firstname;

    private String lastname;

    private Date birthDay;

}
