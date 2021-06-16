/**
 * Copyright (C), 2018-2021, bokecc.com FileName: BooleanToIntSerializer Author:   shaogz Date:     2021/6/16 2:16 PM
 * Description: History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.widget.json.jackson.pojo.p3;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author shaogz
 * @create 2021/6/16
 * @since 1.0.0
 */
public class BooleanToIntSerializer extends JsonSerializer<Boolean> {

    @Override
    public void serialize(Boolean value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        if(value) {
            gen.writeNumber(1);
        } else {
            gen.writeNumber(0);
        }
    }

}
