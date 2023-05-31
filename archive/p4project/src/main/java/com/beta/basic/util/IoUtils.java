/**
 * Copyright (C), 2018-2020, zenki.ai
 * FileName: IoUtils
 * Author:   feiyi
 * Date:     2020/10/22 10:31 AM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta.basic.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2020/10/22
 * @since 1.0.0
 */
public class IoUtils {

    public static String readStreamToStr(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            byte[] b = new byte[2048];
            for (int n; (n = inputStream.read(b)) != -1; ) {
                sb.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
}
