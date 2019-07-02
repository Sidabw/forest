/**
 * Copyright (C), 2018-2019, zenki.ai
 * FileName: MyClassloader
 * Author:   feiyi
 * Date:     2019/6/24 5:23 PM
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.beta;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 〈一句话功能简述〉:
 * 〈〉
 *
 * @author feiyi
 * @create 2019/6/24
 * @since 1.0.0
 */
public class MyClassloader extends ClassLoader{


    @Override
    protected Class<?> findClass(String name) {
        String myPath = "file:///Users/feiyi/Desktop/javatest3/Demo2.class";
        System.out.println(myPath);
        byte[] cLassBytes = null;
        Path path = null;
        try {
            path = Paths.get(new URI(myPath));
            cLassBytes = Files.readAllBytes(path);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        Class clazz = defineClass("Demo2", cLassBytes, 0, cLassBytes.length);
        return clazz;
    }
}
